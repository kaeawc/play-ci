package git

case class Add(files:List[String]) extends GitCommand(files) {

  val command = "add"
  
}