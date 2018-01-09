package com.scala.helloworld

object CurryTest {
  def main(args: Array[String]): Unit = {
    printFullName("Ivanov", fullName("Ivan"))
  }

  def printFullName(surname: String, fullName: String => String): Unit = {
    println(fullName(surname))
  }

  def fullName(name: String)(surname: String): String = s"$name $surname"
}
