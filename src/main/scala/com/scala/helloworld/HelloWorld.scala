package com.scala.helloworld

/**
  * Created by vlados on 10/15/2017.
  */
object HelloWorld {
  def main(args: Array[String]) {
    val helloMessage: String = "Hello world"
    var number: Int = 4
    number = 7
    println(helloMessage + " " + number)

    println({
      val x: Int = 1 + 1
      x + " " + "numbers"
    })

    val addOne = (x: Int) => x + 1

    println(addOne(6))
    println(addOneExt(6))

    def add(x: Int, y: Int): Int = x + y
    println(add(1, 2))

    println(addExt(1, 2))

    val greeter: Greeter = new Greeter("Hello", "Scala")
    greeter.hello()

    val point1 = Point(1, 2)
    val point2 = Point(2, 2)
    val point3 = Point(2, 2)

    if (point1 != point2) {
      println("Point(1, 2) !=  Point(2, 2)")
    }

    if (point2 == point3) {
      println("Point(2, 2) ==  Point(2, 2)")
    }

  }

  def addExt(x: Int, y: Int): Int = x + y

  val addOneExt = (x: Int) => x + 1

}
