package com.scala.helloworld

object Traits {
  def main(args: Array[String]): Unit = {
    val counter: Counter = new Counter
    println(counter.next())
    println(counter.next())
    println(counter.next())
    println(counter.next())
    println(counter.next())
  }
}

class Counter(val maxValue: Int = 10) extends Iterator[Int] {
  private var currentValue: Int = 0

  override def hasNext(): Boolean = maxValue > currentValue

  override def next(): Int = {
    if (hasNext()) {
      val currentTemp = currentValue
      currentValue += 1
      currentTemp
    } else {
      0
    }
  }
}

trait Iterator[T] {
  def hasNext(): Boolean

  def next(): T
}