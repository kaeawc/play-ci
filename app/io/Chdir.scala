package io

case class Chdir(directory:String)
extends shell.Status[String] {

  val command = "cd"

  val input = directory
  
}