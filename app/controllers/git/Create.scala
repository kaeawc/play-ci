// package controllers.git

// import models._
// import git._
// import io._

// import play.api.mvc._
// import play.api.data._
// import play.api.data.Forms._

// import scala.concurrent.{ExecutionContext,Future}
// import ExecutionContext.Implicits.global

// object Create
// extends Controller
// with FormBinding
// with Private {

//   val form = Form(
//     "name" -> text
//   )

//   def post = FormAsync(form) {
//     name =>

//     Make directory name flatMap {
//       case 0 => Change directory name
//       case _ => Future { -1 }
//     } flatMap {
//       case 0 => Git.init
//       case _ => Future { -1 }
//     } map {
//       case 0 => Ok("")
//       case _ => InternalServerError
//     }
//   }
// }
