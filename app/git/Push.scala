package git

case class Push(remote:String = "origin", branch:String = "master") extends GitCommand(s"$remote $branch") {

  val command = "push"
  
}