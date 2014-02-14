package play.api.mvc

import play.api.Play

trait Configuration {

  val config = Play.current.configuration

  lazy val appSecret =
    config.getString("application.secret") match {
      case Some(key:String) => key
      case _ => throw new Exception("Application is missing configuration settings: 'application.secret'")
    }

  lazy val userCookieKey =
    config.getString("cookies.user.key") match {
      case Some(key:String) => key
      case _ => "user"
    }

  lazy val sslEnabled =
    config.getString("ssl.enabled") match {
      case Some(key:String) => true
      case _ => false
    }
}

object Configuration extends Configuration {
  
}