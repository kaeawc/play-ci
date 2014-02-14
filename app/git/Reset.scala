package git

case class Reset(options:String) extends GitCommand(options) {

  val command = "reset"
  
}