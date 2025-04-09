package com.chapter3.ScalaFP

object PureAndNonPureFunction {
  def pureFunc(cityName: String) = s"I live in $cityName"
  def notpureFunc(cityName: String) = println(s"I live in $cityName")
  def pureMul(x: Int, y: Int) = x * y
  def notpureMul(x: Int, y: Int) = println(x * y)
  def main(args: Array[String]) = {
    pureFunc("Madrid")
    notpureFunc("Barcelona")
    pureMul(10, 25)
    notpureMul(10, 25)

    // Now call pureMul method in a different wey
    val data = Seq.range(1, 10).reduce(pureMul)
    println(s"My sequence is: " + data)
  }
}
