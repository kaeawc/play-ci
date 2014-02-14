package git

case class Status(
  short:Option[Boolean],
  branch:Option[Boolean],
  porcelain:Option[Boolean],
  long:Option[Boolean]
) extends GitCommand("") {


  val command = "status"
  
}