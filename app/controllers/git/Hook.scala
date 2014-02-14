// package controllers.git

// import models._

// import play.api.mvc._
// import play.api.data._
// import play.api.data.Forms._

// import scala.concurrent.{ExecutionContext,Future}
// import ExecutionContext.Implicits.global

// object Hook
// extends Controller
// with FormBinding
// with Private {

//   val https = Form(
//     mapping(
//       "email"    -> email,
//       "password" -> text(minLength = 6)
//     )(forms.Login.apply)(forms.Login.unapply)
//   )

//   val ssh = Form[SSHCredentials](
//     mapping(
//       "publicKey" -> text
//     )(SSHCredentials.apply)(SSHCredentials.unapply)
//   )

//   def post = VisitAction { user => Future { Ok(views.html.landing(user)) } }

// }
