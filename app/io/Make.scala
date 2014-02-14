package io

case object Make {

  def directory(name:String) = Mkdir(name) exec
  
}