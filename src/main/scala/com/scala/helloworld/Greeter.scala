package com.scala.helloworld

/**
  * Created by vlados on 10/15/2017.
  */
class Greeter(message: String, name: String) {
  def hello(): Unit = println(message + " " + name)
}
