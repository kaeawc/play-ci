package git

case class Commit(message:String) extends GitCommand(message) {

  val command = "commit"
  
}