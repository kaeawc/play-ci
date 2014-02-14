package git

case class Fetch(remote:String = "origin", branch:String = "master") extends GitCommand(s"$remote $branch") {

  val command = "fetch"
  
}
