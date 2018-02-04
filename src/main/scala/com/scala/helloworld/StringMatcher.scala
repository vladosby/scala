package com.scala.helloworld

object StringMatcher {
  def main(args: Array[String]): Unit = {
    Matcher.findByEnding(".scala").foreach(println)
    println("------------------")
    Matcher.findByContains("bla").foreach(println)
    println("------------------")
    Matcher.findByRegex("111.*111..*").foreach(println)
  }
}

object Matcher {
  private val strings: List[String] = List("Anaaaa.scala", "111ccc111.doc", "blablabla.scala")

  private def findMatching(matcher: String => Boolean) = {
    for {string <- strings if matcher(string)} yield string
  }

  def findByEnding(query: String) = findMatching(_.endsWith(query))

  def findByContains(query: String) = findMatching(_.contains(query))

  def findByRegex(query: String) = findMatching(_.matches(query))

}
