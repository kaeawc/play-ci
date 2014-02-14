package git

case class Log() extends GitCommand("") {

  val command = "log"
  
}