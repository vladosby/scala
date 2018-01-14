package com.scala.helloworld

import scala.util.Random

object ExtractorObjects {
  def main(args: Array[String]): Unit = {
    val name = CustomerId("Name")
    println(name)

    name match {
      case CustomerId(n) => println(n)
      case _ => println("error")
    }

    CustomerId("Name") match {
      case CustomerId(n) => println(n)
      case _ => println("error")
    }
  }
}

object CustomerId {
  def apply(name: String) = raw"$name-${Random.nextInt(100000)}"

  def unapply(customerId: String): Option[String] = {
    if (customerId.nonEmpty) Some(raw"$customerId-unapply") else None
  }
}
