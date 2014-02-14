// package controllers.git

// import models._
// import git._
// import io._

// import play.api.mvc._
// import play.api.data._
// import play.api.data.Forms._

// import scala.concurrent.{ExecutionContext,Future}
// import ExecutionContext.Implicits.global

// object Fork
// extends Controller
// with PrivateForm {

//   val form = Form(
//     "repository" -> text
//   )

//   def post = UserFormAsync(form) {
//     repository =>

//     Git clone repository map {
//       case 0 => Ok("")
//       case _ => InternalServerError
//     }
//   }
// }
