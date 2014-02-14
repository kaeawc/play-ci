package git

case class Bisect(choice:BisectChoice) extends GitCommand(choice) {

  val command = "bisect"
  
}