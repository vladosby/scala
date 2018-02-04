package com.scala.helloworld

object Currying {
  def main(args: Array[String]): Unit = {
    println(sum(1)(2))
    val onePlus = sum(1)_
//    println(onePlus(5)) error

    val twoPlus = sum(2)_
    println(twoPlus(7))

    printSum(onePlus)
  }

  def sum(x: Int)(y: Int) = x + y

  def printSum(x: Int => Int) = println(x(6))
}
