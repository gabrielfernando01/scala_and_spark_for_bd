
object Calculator {
  // Method equivalent to a Java static method
  def sum(a: Int, b: Int): Int = {
    a + b
  }

def main(args: Array[String]): Unit = {
  // Call method sum without create a object
  val result = Calculator.sum(2, 11)
  println("The sum is: " + result)
  }
}


