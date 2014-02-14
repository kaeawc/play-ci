package play.api.mvc

import models._

import play.api.Logger
import play.api.libs.Crypto
import play.api.libs.json.Json
import play.api.mvc.Results._

import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

trait CookieAuthentication
extends CookieManagement
with Configuration {

  val couldNotCreateAuthCookie = Future {
    InternalServerError(Json.obj(
      "reason" -> "We could not create a secure persistant cookie for you."
    ))
  }

  def removeAuthCookie(implicit result:Future[SimpleResult]) =
    removeCookie(userCookieKey,result)

  def replaceAuthCookie(implicit result:Future[SimpleResult], user:User) =
    createAuthCookie(user.id) map {
      case Some(cookie:Cookie) =>
        replaceCookie(userCookieKey,result,cookie)
      case _ =>
        removeCookie(userCookieKey,couldNotCreateAuthCookie)
    }

  /**
   * creates a Cookie instance with an encrypted value
   */
  def createSessionCookie(session:UserSession):Option[Cookie] = {

    try {
      val expires = Option(31536000)
      val value = Crypto.encryptAES(Json.toJson(session).toString)
      Some(Cookie(userCookieKey, value, expires, "/", None, sslEnabled))
    } catch {
      case e:Exception => {
        Logger.error("Couldn't create a cookie for this user.")
        None
      }
    }
  }
  
  /**
   * creates a Cookie instance with an encrypted value
   */
  def createAuthCookie(user:Long) = {
    UserSession.create(user) map {
      case Some(session:UserSession) => createSessionCookie(session)
      case _ => {
        Logger.error("Couldn't create a User Session.")
        None
      }
    }
  }

  /**
   * attempts to decode the current user's cookie
   */
  def getUserFromCookie(request:play.api.mvc.RequestHeader):Future[Option[UserSession]] = {  
    
    try {

      val cookie = request.cookies.get(userCookieKey).get
      
      val session = Crypto.decryptAES(cookie.value)

      UserSession.parse(session)
    } catch {
      case e:Exception => Future { None }
    }
  }
}