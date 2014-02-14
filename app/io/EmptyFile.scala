package io

case class EmptyFile(filePath:String)
extends shell.Status[String] {

  val command = "\"\" >"

  val input = filePath
  
}