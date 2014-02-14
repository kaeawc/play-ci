// package play.api.mvc

// import models.User

// import play.api.mvc.Results._
// import play.api.data.Form
// import play.api.data.Forms._

// import scala.concurrent.{ExecutionContext,Future}
// import ExecutionContext.Implicits.global

// trait PrivateForm extends FormBinding with Private {

//   override def FormAsync[Tuple]
//     (form    : Form[Tuple])
//     (success : Tuple => Future[SimpleResult]) =
//   Action.async { implicit request =>
//     IfLoggedIn[AnyContent](BindAsync(form)(success))
//   }

//   override def FormAction[Tuple]
//     (form    : Form[Tuple])
//     (success : Tuple => SimpleResult) =
//   Action.async { implicit request => 
//     IfLoggedIn[AnyContent](BindForm(form)(success))
//   }

//   /**
//    * If request has authenticated user state do action A, otherwise do action B
//    */
//   def UserFormAsync[Tuple](
//     form    : Form[Tuple]
//   )(
//     success : Tuple => Future[SimpleResult],
//     error   : Future[SimpleResult] = { Future { Unauthorized(views.html.error.denied()) } }
//   ) = Action.async {
//     implicit request:Request[AnyContent] =>
//     OnlyUserFormAsync(form)(success,error)
//   }

//   /**
//    * If request has authenticated user state do action A, otherwise do action B
//    */
//   def OnlyUserFormAsync[Tuple](
//     form    : Form[Tuple]
//   )(
//     success : Tuple => Future[SimpleResult],
//     error   : Future[SimpleResult]
//   )(implicit request:Request[AnyContent]) = {
//     userVisit[AnyContent] flatMap {
//       case Some(user:User) => BindAsync(form)(success)
//       case _               => error
//     }
//   }

//   /**
//    * If request has authenticated user state do action A, otherwise do action B
//    */
//   def WithUserFormAsync[Tuple](
//     form    : Form[Tuple]
//   )(
//     success : User => Tuple => Future[SimpleResult],
//     error   : Future[SimpleResult] = { Future { Unauthorized(views.html.error.denied()) } }
//   ) = Action.async {
//     implicit request:Request[AnyContent] =>
//     userVisit[AnyContent] flatMap {
//       case Some(user:User) => BindAsync(form)(success(user))
//       case _               => error
//     }
//   }
// }
