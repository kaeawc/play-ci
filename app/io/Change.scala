package io

case object Change {

  def directory(name:String) = Chdir(name) exec
  
}