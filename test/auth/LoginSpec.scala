// package controllers.auth

// import test._
// import play.api.test._
// import play.api.test.Helpers._
// import play.api.libs.json._

// import scala.concurrent.ExecutionContext.Implicits.global

// class LoginSpec extends Specification {

//   "GET /login" should {

//     "render the login page" in new WithApp {

//       val request = FakeRequest(GET, "/login")

//       val response = route(request).get

//       status(response) must equalTo(OK)
//     }
//   }

//   "POST /login" should {

//     "return a BadRequest status when no data is provided" in new WithApp {

//       val request = FakeRequest(POST, "/login")

//       val response = route(request).get

//       status(response) must equalTo(400)

//       contentAsString(response) mustEqual "Could not bind form."
//     }
//   }

//   "POST /login" should {

//     "return a Unauthorized status when incorrect data is provided" in new WithApp {

//       val header = FakeRequest(POST, "/login")

//       val body = Json.obj(
//         "email"    -> "user@example.com",
//         "password" -> "thisisapassword"
//       )

//       val response = route(header,body).get

//       status(response) must equalTo(401)
//     }
//   }

//   "POST /login" should {

//     "return an Accepted status when correct credentials are provided" in new WithApp {

//       createUser("user@example.com","thisisapassword") map {
//         user =>

//         val header = FakeRequest(POST, "/login")

//         val body = Json.obj(
//           "email"    -> "user@example.com",
//           "password" -> "thisisapassword"
//         )

//         val response = route(header,body).get

//         status(response) must equalTo(201)

//         val json = Json.parse(contentAsString(response))

        
//       }
//     }
//   }
// }
