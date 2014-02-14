// package controllers.git

// import models._
// import git._

// import play.api.mvc._
// import play.api.data._
// import play.api.data.Forms._

// import scala.concurrent.{ExecutionContext,Future}
// import ExecutionContext.Implicits.global

// object Branch
// extends Controller
// with FormBinding
// with Private {

//   val form = Form(
//     "name" -> text
//   )

//   def post = FormAsync(form) {
//     name =>

//     Git branch name map {
//       case 0 => Ok("")
//       case _ => InternalServerError
//     }
//   }

// }
