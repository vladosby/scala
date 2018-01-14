package com.scala.helloworld

object Comprehensions {
  def main(args: Array[String]): Unit = {
    val users = List(User("Travis", 28),
      User("Kelly", 33),
      User("Jennifer", 44),
      User("Dennis", 23))

    val notOldUsers = for (user <- users if user.age >= 20 && user.age < 30)
      yield user.name

    println(notOldUsers)

    def foo(n: Int, v: Int) =
      for (i <- 0 until n;
           j <- i until n if i + j == v)
        yield (i, j)

    foo(10, 10) foreach {
      case (i, j) =>
        print(s"($i, $j) ")  // prints (1, 9) (2, 8) (3, 7) (4, 6) (5, 5)
    }
  }
}

case class User(name: String, age: Int)


