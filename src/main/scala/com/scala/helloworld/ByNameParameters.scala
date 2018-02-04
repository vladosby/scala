package com.scala.helloworld

object ByNameParameters {
  val needCheck = true;

  def main(args: Array[String]): Unit = {

    println(isPrintMessage(5 > 3))
    println(isPrintMessage(1 > 3))

    tryWithResource("test.txt") {
      println
    }
  }

  def isPrintMessage(expression: => Boolean): Boolean = needCheck && expression // by name parameters

  def tryWithResource(file: String)(reader: Any => Unit) = {  // new control structures, try with resources
    println(s"Open file $file")
    try {
      reader("content of file")
    } finally {
      println(s"Close file $file")
    }
  }
}
