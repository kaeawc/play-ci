package git

case class Branch(branch:String) extends GitCommand(branch) {

  val command = "branch"
  
}