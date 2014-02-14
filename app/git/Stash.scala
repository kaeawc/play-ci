package git

case class Stash(files:List[String]) extends GitCommand(files) {

  val command = "stash"
  
}