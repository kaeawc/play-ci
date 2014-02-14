package git

case class Rebase(options:String) extends GitCommand(options) {

  val command = "rebase"
  
}