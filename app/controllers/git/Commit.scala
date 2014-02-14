// package controllers.git

// import models._
// import git._

// import play.api.mvc._
// import play.api.data._
// import play.api.data.Forms._

// import scala.concurrent.{ExecutionContext,Future}
// import ExecutionContext.Implicits.global

// object Commit
// extends Controller
// with FormBinding
// with Private {

//   val form = Form(
//     "message" -> text
//   )

//   def post = FormAsync(form) {
//     message =>

//     Git commit message map {
//       case 0 => Ok("")
//       case _ => InternalServerError
//     }
//   }

// }
