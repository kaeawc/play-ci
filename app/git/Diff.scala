package git

case class Diff(files:List[String]) extends GitCommand(files) {

  val command = "diff"
  
}