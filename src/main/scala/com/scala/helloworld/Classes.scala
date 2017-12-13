
class Point(var x: Int, var y: Int)
class PointWithDefaultValues(var x: Int = 10, var y: Int = 20)
class PointWithGetterAndSetter {
  private var _x: Int = 0
  private var _y: Int = 0

  def x = _x

  def x_= (newX: Int): Unit = {
    if (newX > 0) _x = newX else printErrorMessage
  }

  def y = _y

  def y_= (newY: Int): Unit = {
    if (newY > 0) _y = newY else printErrorMessage
  }

  private def printErrorMessage = println("Invalid value was passed in the method")
}

object Classes {
  def main(args: Array[String]): Unit = {
    val simpleClass: Point = new Point(5, 6)
    println("x = " + simpleClass.x + " y = " + simpleClass.y)

    val pointWithDefaultValues: PointWithDefaultValues = new PointWithDefaultValues
    println("x = " + pointWithDefaultValues.x + " y = " + pointWithDefaultValues.y)

    val customizedSecondValue: PointWithDefaultValues = new PointWithDefaultValues(y = 7)
    println("x = " + customizedSecondValue.x + " y = " + customizedSecondValue.y)

    val pointWithGetterAndSetter: PointWithGetterAndSetter = new PointWithGetterAndSetter
    pointWithGetterAndSetter.x = 100
    pointWithGetterAndSetter.y = -10
    println("x = " + pointWithGetterAndSetter.x + " y = " + pointWithGetterAndSetter.y)

  }
}