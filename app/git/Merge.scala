package git

case class Merge(repository:String) extends GitCommand(repository) {

  val command = "merge"
  
}