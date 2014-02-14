// package controllers.git

// import models._
// import git._

// import play.api.mvc._
// import play.api.data._
// import play.api.data.Forms._

// import scala.concurrent.{ExecutionContext,Future}
// import ExecutionContext.Implicits.global

// object Add
// extends Controller
// with FormBinding
// with Private {

//   val form = Form(
//     "files" -> list(text)
//   )

//   def post = FormAsync(form) {
//     files =>

//     Git add files map {
//       case 0 => Ok("")
//       case _ => InternalServerError
//     }
//   }
// }
