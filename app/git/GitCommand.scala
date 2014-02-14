package git

import sys.process._

import scala.concurrent.{ExecutionContext,Future}
import ExecutionContext.Implicits.global

abstract class GitCommand[Input](input:Input) {

  val command:String

  def exec:Future[Int] = Future {
    s"git $command $input" !
  }
}