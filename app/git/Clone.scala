package git

case class Clone(repository:String) extends GitCommand(repository) {

  val command = "clone"
  
}