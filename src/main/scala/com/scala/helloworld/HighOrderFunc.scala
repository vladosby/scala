package com.scala.helloworld

object HighOrderFunc {
  def main(args: Array[String]): Unit = {
    val salaries1 = Seq(1, 2, 3)
    val doubleSalary = (x: Int) => x * 2
    val newSalaries1 = salaries1.map(doubleSalary)
    println("new salaries " + newSalaries1)

    val salaries2 = Seq(4, 5, 6)
    val newSalaries2 = salaries2.map(x => x * 2)
    println("new salaries " + newSalaries2)

    val salaries3 = Seq(7, 8, 9)
    val newSalaries3 = salaries3.map(_ * 2)
    println("new salaries " + newSalaries3)

    println(SalaryRaiser.hugePromotion(List(5, 10, 20)))

    println(urlBuilder(false, "blablabla")("test", "all"))
  }

  def urlBuilder(ssl: Boolean, domainName: String): (String, String) => String = {
    val schema = if (ssl) "https://" else "http://"
    (endpoint: String, query: String) => s"$schema$domainName/$endpoint?$query"
  }
}

object SalaryRaiser {

  private def promotion(salaries: List[Double], promotionFunction: Double => Double): List[Double] =
    salaries.map(promotionFunction)

  def smallPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * 1.1)

  def bigPromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * math.log(salary))

  def hugePromotion(salaries: List[Double]): List[Double] =
    promotion(salaries, salary => salary * salary)
}
