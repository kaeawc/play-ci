package git

case class Checkout(branch:String) extends GitCommand(branch) {

  val command = "checkout"
  
}