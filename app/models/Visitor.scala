package models

import anorm._
import anorm.SqlParser._
import scala.concurrent.{ExecutionContext, Future}
import ExecutionContext.Implicits.global

import play.api.Logger
import play.api.mvc._
import play.api.db._
import play.api.Play.current
import play.api.libs.json._

import java.util.Date

case class Visitor(
  id        : Long,
  uri       : String,
  userAgent : Option[String],
  user      : Option[Long],
  created   : Date
)

object Visitor extends ((
  Long,
  String,
  Option[String],
  Option[Long],
  Date
) => Visitor) with CookieAuthentication {

  implicit val jsonFormat = Json.format[Visitor]

  val sqlResult =
    get[Long]("id") ~
    get[String]("uri") ~
    get[Option[String]]("userAgent") ~
    get[Option[Long]]("user") ~
    get[Date]("created")

  val visitors = sqlResult map {
    case   id~uri~userAgent~user~created =>
      Visitor(id,uri,userAgent,user,created)
  }

  def fetch = Future {
    DB.withConnection { implicit connection =>
      SQL(
        """
          SELECT
            id,uri,userAgent,user,created
          FROM visitor
          ORDER BY created DESC
          LIMIT 100;
        """
      ).as(visitors *)
    }
  }

  def countAll = Future {
    DB.withConnection { implicit connection =>
      val result = SQL(
        """
          SELECT COUNT(1) count
          FROM visitor;
        """
      ).apply()

      try {
        Some(result.head[Long]("count"))
      } catch {
        case e:Exception => None
      }
    }
  }

  def log(request:RequestHeader):Future[Option[UserSession]] = {

    val created = new Date()

    val uri = request.uri

    val userAgent = request.headers.get("User-Agent")

    getUserFromCookie(request) map {
      session =>
      val userId = session match {
        case Some(session:UserSession) => Some(session.user)
        case _ => None
      }

      DB.withConnection { implicit connection =>
        val id = SQL(
          s"""
            INSERT INTO visitor (
              uri,
              userAgent,
              user,
              created
            ) VALUES (
              {uri},
              {userAgent},
              {user},
              {created}
            );
          """
        ).on(
          'uri       -> uri,
          'userAgent -> userAgent,
          'user      -> userId,
          'created   -> created
        ).executeInsert()

        if (id.isEmpty)
          Logger.error("Failed to log visitor")
      }
      
      session
    }
  }
}
