package com.scala.helloworld

object Variances {
  def main(args: Array[String]): Unit = {
    println("---- Animal names ------")
    val cats: List[Cat1] = List(Cat1("Barsik"), Cat1("Drakosha")) // The Scala standard library has a generic immutable sealed abstract class List[+A] class
    val dogs: List[Dog1] = List(Dog1("Sharik"), Dog1("Bobik"))
    printAnimalNames(cats)
    printAnimalNames(dogs)
    println("---- Animal names ------")


    val myCat: Cat1 = Cat1("Micky")

    def printMyCat(printer: Printer[Cat1]): Unit = {
      printer.print(myCat)
    }

    val catPrinter: Printer[Cat1] = new CatPrinter
    val animalPrinter: Printer[Animal] = new AnimalPrinter

    printMyCat(catPrinter)
    printMyCat(animalPrinter)


    val catContainer: Container[Cat1] = new Container(Cat1("Felix"))
//    val animalContainer: Container[Animal] = catContainer  not working
//    animalContainer.setValue(Dog1("Spot"))
  }

  def printAnimalNames(animals: List[Animal]) = animals.foreach(a => println(a.name))

}


abstract class Animal {
  def name: String
}

case class Cat1(name: String) extends Animal
case class Dog1(name: String) extends Animal


abstract class Printer[-A] {
  def print(value: A): Unit
}

class AnimalPrinter extends Printer[Animal] {
  override def print(animal: Animal): Unit = println("The animal name is: " + animal.name)
}

class CatPrinter extends Printer[Cat1] {
  override def print(animal: Cat1): Unit = println("The cat name is: " + animal.name)
}

class Container[A](value: A) {
  private var _value: A = value
  def getValue: A = _value
  def setValue(value: A): Unit = {
    _value = value
  }
}