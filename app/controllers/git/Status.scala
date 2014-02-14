// package controllers.git

// import models._
// import git._

// import play.api.mvc._
// import play.api.data._
// import play.api.data.Forms._

// import scala.concurrent.{ExecutionContext,Future}
// import ExecutionContext.Implicits.global

// object Status
// extends Controller
// with FormBinding
// with Private {

//   val form = Form(tuple(
//     "short" -> optional(boolean),
//     "branch" -> optional(boolean),
//     "porcelain" -> optional(boolean),
//     "long" -> optional(boolean)
//   ))

//   def post = FormAsync(form) {
//     options =>

//     Git status options map {
//       case 0 => Ok("")
//       case _ => InternalServerError
//     }
//   }

// }
