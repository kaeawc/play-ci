package controllers.auth

import play.api.Logger
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.libs.json._

import scala.concurrent.{ExecutionContext,Future}
import ExecutionContext.Implicits.global

import models._


object Signup
extends Controller {

  def submit = Action {
    Ok("")
  }
}

// object Signup
// extends Controller
// with Private
// with FormBinding
// with CookieManagement {

//   val signupForm = Form(
//     mapping(
//       "email"           -> email,
//       "password"        -> text(minLength = 6),
//       "retyped" -> text(minLength = 6)
//     )(forms.Signup.apply)(forms.Signup.unapply) verifying("Passwords must match",
//       fields => fields match {
//         case data:forms.Signup => {
//           data.password == data.retyped
//         }
//       }
//     )
//   )

//   def getForm = VisitAction { implicit user => Future { Ok(template(signupForm)) } }

//   def template(form:Form[forms.Signup]) = views.html.auth.signup(form,None)

//   def submit = OnlyPublicAction {

//     implicit request =>

//     BindAsync(signupForm,template) {
//       signup:forms.Signup => User.create(signup.email,signup.password) flatMap {
//         case Some(user:User) =>
//           createUserCookie(user.id) map {
//             case Some(cookie:Cookie) =>
//               replaceCookie(Redirect(controllers.routes.Application.landing),cookie)
//             case _ =>
//               InternalServerError(Json.obj("reason" -> "We could not create a secure persistant cookie for you."))
//           }
//         case _ =>
//           Future { NotFound }
//       }
//     }
//   }

// }