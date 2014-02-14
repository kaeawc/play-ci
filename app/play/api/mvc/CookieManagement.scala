package play.api.mvc

import play.api.Logger
import play.api.libs.Crypto
import scala.concurrent.{Future,ExecutionContext}
import ExecutionContext.Implicits.global

trait CookieManagement {

  def removeCookie(key:String,result:Future[SimpleResult]):Future[SimpleResult] =
    result map { result => result.discardingCookies(DiscardingCookie(key)) }

  def replaceCookie(key:String,result:Future[SimpleResult],cookie:Cookie):Future[SimpleResult] =
    result map { result => result.discardingCookies(DiscardingCookie(key)).withCookies(cookie) }

  /**
   * reads a RequestHeader's Cookie by the given key if it exists
   */
  def readCookie(request:play.api.mvc.RequestHeader,key:String):String = {
    val cookie = request.cookies.get(key)
    cookie match {
      case Some(c:play.api.mvc.Cookie) => {
        Crypto.decryptAES(c.value)
      }
      case _ => throw new Exception("Could not read key [" + key + "] from cookie in request.")
    }
  }
}