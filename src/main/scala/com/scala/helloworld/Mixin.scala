package com.scala.helloworld

object Mixin {
  def main(args: Array[String]): Unit = {
    val cat: CatWithMixin = new CatWithMixin
    println(cat.name)
    println(cat.getUppercaseName)
  }
}

abstract class Pet {
  val name: String
}

class Cat extends Pet {
  val name = "Boris"
}

trait UppercaseNameMixin extends Pet {
  def getUppercaseName: String = name.toUpperCase()
}

class CatWithMixin extends Cat with UppercaseNameMixin
