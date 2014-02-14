package git

case class Init() extends GitCommand("") {

  val command = "init"
  
}