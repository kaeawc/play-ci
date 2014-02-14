// package io

// import sys.process._

// import scala.concurrent.{ExecutionContext,Future}
// import ExecutionContext.Implicits.global

// abstract class IOCommand[Input](input:Input) {

//   val command:String

//   def exec:Future[Int] = Future {
//     s"$command $input" !
//   }
// }
