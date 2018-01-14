package com.scala.helloworld

import scala.util.matching.Regex

object RegularExpressions {

  val numberPattern: Regex = "[1-9]".r

  def main(args: Array[String]): Unit = {
    checkPassword("password")
    checkPassword("1111password")
  }

  def checkPassword(password: String) = {
    numberPattern.findFirstMatchIn(password) match {
      case Some(_) => println("password OK")
      case None => println("Bad password")
    }
  }
}
