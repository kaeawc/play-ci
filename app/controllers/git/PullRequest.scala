// package controllers.git

// import models._
// import git._
// import io._

// import play.api.mvc._
// import play.api.data._
// import play.api.data.Forms._

// import scala.concurrent.{ExecutionContext,Future}
// import ExecutionContext.Implicits.global

// object PullRequest
// extends Controller
// with PrivateForm {

//   import models.PullRequest._

//   val form = Form[PullRequest](
//     mapping(
//       "from" -> tuple(
//         "remote" -> text,
//         "branch" -> text
//       ),
//       "to" -> tuple(
//         "remote" -> text,
//         "branch" -> text
//       )
//     )(fromForm)(toForm)
//   )

//   def post = UserFormAsync(form) {
//     repository =>

//     val from = repository.from.remote + "/" + repository.from.branch
//     val to = repository.to.remote + "/" + repository.to.branch

//     Git checkout to flatMap {
//       case 0 => Git merge from
//       case _ => Future { -1 }
//     } map {
//       case 0 => Ok("")
//       case _ => InternalServerError
//     }

//   }
// }
