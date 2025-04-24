// =============================================================

object Curry {
  def curry[X, Y, Z](f: (X, Y) => Z): X => Y => Z = x => y => f(x, y)
  def suma(x: Int, y: Int): Int = x + y
  val curriedSuma = curry(suma)   // Convierte suma en X => Y => Z
  val sumaCon5 = curriedSuma(5)   // Fija x = 5, devuelve una función Y => Z

  def uncurry[X, Y, Z](f: X => Y => Z): (X, Y) => Z = (x, y) => f(x)(y)
  def curriedSum(x: Int)(y: Int): Int = x + y
  val sumaNormal = uncurry(curriedSum)    // Convierte a (Int, Int) => Int

  def main(args: Array[String]): Unit = {
    println("La suma currificada es: " + sumaCon5(7))
    println("La suma incurrificada es: " + sumaNormal(6, 11))
  }
}
