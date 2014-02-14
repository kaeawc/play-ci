package shell

import sys.process._

import scala.concurrent.{ExecutionContext,Future}
import ExecutionContext.Implicits.global

trait Status[Input] {

  val command:String

  val input:Input

  def exec:Future[Int] = Future {
    s"$command $input" !
  }
}