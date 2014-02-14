package models

import test._

import scala.concurrent.ExecutionContext.Implicits.global

class UserSpec extends Specification {

  "User.getById" should {

    "return a single user" in new WithApp {

      User.create("some.one@example.com","asdfasdf") map {
        case Some(expected:User) => {
          User.getById(1) map {
            case Some(actual:User) => {
              expected mustEqual actual
            }
            case _ => failure("Couldn't retrieve the user who matches this email address.")
          }
        }
        case _ => failure("Couldn't create a user")
      }
    }

    "return nothing if the user does not exist" in new WithApp {

      User.getById(1) map {
        case Some(user:User) => failure("This user should not exist.")
        case _ => success
      }
    }
  }

  "User.getByEmail" should {

    "return a single user when the email exists" in new WithApp {

      User.create("some.one@example.com","asdfasdf") map {
        case Some(expected:User) => {
          User.getByEmail("some.one@example.com") map {
            case Some(actual:User) => {
              expected mustEqual actual
            }
            case _ => failure("Couldn't retrieve the user who matches this email address.")
          }
        }
        case _ => failure("Couldn't create a user")
      }
    }
  }

  "User.create" should {

    "create a single user when the email does not exist" in new WithApp {

      User.create("some.one@example.com","asdfasdf") map {
        case Some(user:User) => {
          user.id    mustEqual 1 
          user.email mustEqual "some.one@example.com"
        }
        case _ => failure("Couldn't create a user")
      }
    }
  }
}