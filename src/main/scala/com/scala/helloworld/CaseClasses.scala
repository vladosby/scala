package com.scala.helloworld

object CaseClasses {
  def main(args: Array[String]): Unit = {
    val firstBook = Book("Games of thrones", 1)
    val secondBook = Book("Games of thrones", 1)
    println(firstBook.name)

    println("if the same books = " + (firstBook == secondBook))
    println(firstBook.copy(bookId = 10))
  }
}

case class Book(name: String, bookId: Int)
