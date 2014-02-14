package controllers.auth

import play.api.Logger
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.libs.json._

import scala.concurrent.{ExecutionContext,Future}
import ExecutionContext.Implicits.global

import models._

// object Login
// extends Controller
// with FormBinding
// with Public
// with Private
// with CookieManagement {

//   val form = Form(
//     mapping(
//       "email"    -> email,
//       "password" -> text(minLength = 6)
//     )(forms.Login.apply)(forms.Login.unapply)
//   )

//   def getForm = OnlyPublic { Ok(views.html.auth.login(form,None)) }

//   def template(form:Form[forms.Login]) = views.html.auth.login(form)

//   def submit = OnlyPublicAction {

//     implicit request =>

//     BindAsync(form,template) {
//       login:forms.Login =>

//       User.authenticate(login.email,login.password) flatMap {
//         case Some(user:User) =>
//           createUserCookie(user.id) map {
//             case Some(cookie:Cookie) =>
//               replaceCookie(Redirect(controllers.routes.Application.landing),cookie)
//             case _ =>
//               InternalServerError(Json.obj("reason" -> "We could not create a secure persistant cookie for you."))
//           }
//         case _ =>
//           Future { Unauthorized(Json.obj("reason" -> "Your credentials are invalid.")) }
//       }
//     }
//   }
// }



object Login
extends Controller {

  def submit = Action {
    Ok("")
  }
}