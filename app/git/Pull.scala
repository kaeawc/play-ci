package git

case class Pull(remote:String = "origin", branch:String = "master") extends GitCommand(s"$remote $branch") {

  val command = "pull"
  
}