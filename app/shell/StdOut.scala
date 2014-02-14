package shell

import sys.process._

import scala.concurrent.{ExecutionContext,Future}
import ExecutionContext.Implicits.global

trait StdOut[Input] {

  val command:String

  val input:Input

  def exec:Future[String] = Future {
    s"$command $input" !!
  }
}