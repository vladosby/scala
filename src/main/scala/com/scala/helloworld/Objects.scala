package com.scala.helloworld

object Objects {
  import TestObject._
  import IntPair._

  def main(args: Array[String]): Unit = {
    println(sum(List(1, 2, 3)))

    val pair = new IntPair(5, 3)
    val pairs = Seq(new IntPair(5, 3), new IntPair(1, 2), new IntPair(2, 6))
    //ipord


    pairs.foreach(o => ipord)
    pairs.foreach(o => println(s"${o.x} ${o.y}"))
  }
}


object TestObject {
  def sum(list: List[Int]): Int = list.sum
}

// how can it be used??

class IntPair(val x: Int, val y: Int)

object IntPair {
  import math.Ordering

  implicit def ipord: Ordering[IntPair] = Ordering.by(ip => (ip.x, ip.y))
}