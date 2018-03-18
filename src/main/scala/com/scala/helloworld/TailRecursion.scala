package com.scala.helloworld

import scala.annotation.tailrec

object TailRecursion {
  def main(args: Array[String]): Unit = {
    println(factorial(3))
  }

  def factorial(n: Int): Int = {
    @tailrec
    def fact(n: Int, accumulator: Int): Int = {
      if (n == 1) accumulator
      else fact(n - 1, n * accumulator)
    }

    fact(n, 1)
  }
}
