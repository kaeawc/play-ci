package play.api.mvc

import models._

import play.api.Logger

import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

trait Monitoring extends CookieAuthentication {

  def SessionAction(
    a       : Option[User] => Future[SimpleResult],
    session : UserSession
  )(implicit
    request:Request[AnyContent]
  ) = {
    User.getById(session.user) flatMap {
      case Some(user:User) => a(Some(user))
      case _ => removeAuthCookie(a(None))
    }
  }

  /**
   * If request has authenticated user state do action A, otherwise do action B
   */
  def VisitAction(
    a: Option[User] => Future[SimpleResult]
  ) = Action.async {
    implicit request:Request[AnyContent] =>

    Visitor.log(request) flatMap {
      case Some(session:UserSession) => SessionAction(a,session)
      case _ => removeAuthCookie(a(None))
    }
  }
}
