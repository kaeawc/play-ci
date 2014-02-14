package play.api.mvc

import models._

import play.api.mvc.Results._
import play.api.libs.json._
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc.BodyParsers._
import play.api.templates.HtmlFormat

import scala.concurrent.{ExecutionContext,Future}
import ExecutionContext.Implicits.global

trait FormBinding extends Monitoring {

  def badForm[Tuple](
    form     : Form[Tuple],
    template : Form[Tuple] => HtmlFormat.Appendable
  ):Future[SimpleResult] = Future { BadRequest(template(form)) }

  def goodForm[Tuple](
    user     : Option[User],
    tuple    : Tuple,
    success  : BoundUser[Tuple]
  ) = success(user)(tuple)

  def goodForm[Tuple](
    tuple    : Tuple,
    success  : Bound[Tuple]
  ) = success(tuple)

  type BoundUser[Tuple] = Option[User] => Tuple => Future[SimpleResult]
  type Bound[Tuple] = Tuple => Future[SimpleResult]

  def FormAction[Tuple](
    form       : Form[Tuple],
    template   : Form[Tuple] => HtmlFormat.Appendable
  )(
    success    : BoundUser[Tuple]
  ) = Action.async {
    implicit request =>
    Visitor.log(request) flatMap {
      case Some(session:UserSession) => User.getById(session.user)
      case _ => Future { None }
    } flatMap {
      case Some(user:User) => form.bindFromRequest match {
        case form:Form[Tuple] if !form.hasErrors => goodForm(Some(user), form.get, success)
        case _ => badForm(form, template)
      }
      case _ => removeAuthCookie(badForm(form, template))
    }
  }

  // def FormAsync[Tuple](
  //   form     : Form[Tuple],
  //   template : Form[Tuple] => HtmlFormat.Appendable
  // )(
  //   success  : Bound[Tuple]
  // ) = Action.async {
  //   implicit request => BindAsync(form,template)(success)
  // }

  // def FormAsync[Tuple](
  //   form    : Form[Tuple]
  // )(
  //   success : Bound[Tuple]
  // ) = Action.async {
  //   implicit request => BindAsync(form)(success)
  // }

  // def badFormAsJson[Tuple](form:Form[Tuple]) = Future {
    
  //   val data = seqToJson(form.errors.map {
  //     error => error.key -> error.message
  //   })

  //   BadRequest(data)
  // }


  // def BindAsync[Tuple](
  //   form    : Form[Tuple]
  // )(
  //   success : Tuple => Future[SimpleResult]
  // )(implicit request:Request[AnyContent]) = {
  //   form.bindFromRequest match {
  //     case form:Form[Tuple] if !form.hasErrors => success(form.get)
  //     case _ => badFormAsJson(form)
        
  //   }
  // }

  // def BindAsync[Tuple](
  //   form     : Form[Tuple],
  //   template : Form[Tuple] => HtmlFormat.Appendable
  // )(
  //   success  : Bound[Tuple]
  // )(implicit
  //   request  : Request[AnyContent]
  // ) = form.bindFromRequest match {
  //     case form:Form[Tuple] if !form.hasErrors => success(form.get)
  //     case _ => badForm(form, template)
  //   }

  // def BindUserAsync[Tuple](
  //   form     : Form[Tuple],
  //   template : Form[Tuple] => HtmlFormat.Appendable
  // )(
  //   success  : Bound[Tuple]
  // )(implicit 
  //   request  : Request[AnyContent],
  //   user     : Option[User]
  // ) = form.bindFromRequest match {
  //     case form:Form[Tuple] if form.hasErrors => badForm(form, template)
  //     case form:Form[Tuple] => success(form.get)
  //   }

  // def BindForm[Tuple](
  //   form    : Form[Tuple]
  // )(
  //   success : Tuple => SimpleResult
  // )(implicit
  //   request  : Request[AnyContent]
  // ) = form.bindFromRequest match {
  //     case form:Form[Tuple] if !form.hasErrors => Future { success(form.get) }
  //     case _ => badFormAsJson(form)
  //   }

  // def FormAction[Tuple]
  //   (form    : Form[Tuple])
  //   (success : Tuple => SimpleResult) =
  // Action.async { implicit request => 
  //   BindForm(form)(success)
  // }
}
