package io

case class Mkdir(directory:String)
extends shell.Status[String] {

  val command = "mkdir"

  val input = directory
  
}