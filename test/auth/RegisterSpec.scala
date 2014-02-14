// package controllers.auth

// import test._
// import models.User

// import play.api.test._
// import play.api.test.Helpers._
// import play.api.libs.json._

// import scala.concurrent.ExecutionContext.Implicits.global

// class RegisterSpec extends Specification {

//   "GET /signup" should {

//     "render the signup page" in new WithApp {

//       val request = FakeRequest(GET, "/signup")

//       val response = route(request).get

//       status(response) must equalTo(OK)
//     }
//   }

//   "POST /signup" should {

//     "return a BadRequest status when no data is provided" in new WithApp {

//       val request = FakeRequest(POST, "/signup")

//       val response = route(request).get

//       status(response) must equalTo(400)

//       contentAsString(response) mustEqual "Could not bind form."
//     }
//   }

//   "POST /signup" should {

//     "return a Unauthorized status when incorrect data is provided" in new WithApp {

//       val header = FakeRequest(POST, "/signup")

//       val body = Json.obj(
//         "email"    -> "user@example.com",
//         "password" -> "thisisapassword",
//         "retyped" -> "thisisapassword"
//       )

//       val response = route(header,body).get

//       status(response) must equalTo(201)

//       val json = Json.parse(contentAsString(response))

//       val id = (json \ "user" \ "id").as[Long]

//       User.getById(id) map {
//         case Some(actual:User) => {
//           actual.id mustEqual 1
//           actual.email mustEqual "user@example.com"
//         }
//         case _ => failure("User that we just created does not exist in the database.")
//       }
//     }
//   }
// }
