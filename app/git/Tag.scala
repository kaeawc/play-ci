package git

case class Tag(tag:String) extends GitCommand(tag) {

  val command = "tag"
  
}