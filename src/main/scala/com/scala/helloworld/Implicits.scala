package com.scala.helloworld

object Implicits {
  import converter._

  def main(args: Array[String]): Unit = {
    val integer = Integer(1)
    println(integer + 10)

    val list = CustomList(List(5,4,3,2,1))
    val sorted1 = list.sort1(i => i)
    val sorted2 = list.sort2(i => i)
    println(sorted1)
    println(sorted2)

    println(10 print (_ + 5))

    println(TypeConstraint("1234").getLength)
//    TypeConstraint(111).getLength runtime error
  }

  implicit class IntPrint(x: Int) {
    def print(f: Int => Int): Int = {
      println(s"$x")
      f(x)
    }
  }

}

case class Integer(i: Int)

object converter {
  implicit def integerToInt(integer: Integer): Int = {
    integer.i
  }
}

case class CustomList[T](list: List[T]) {
  def sort1[B](f: T => B)(implicit order: Ordering[B]): List[T] = {
    list.sortBy(f)(order)
  }

  // the same as previous
  def sort2[B : Ordering](f: T => B): List[T] = {
    list.sortBy(f)(implicitly[Ordering[B]])
  }
}

case class TypeConstraint[A](a: A) {
  def getLength(implicit ev: A =:= String) = a.length
}


