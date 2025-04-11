package com.chapter3.ScalaFP

object HigherOrderFunction {
  def quarterMaker(value: Int): Double = value.toDouble/4
  def testHOF(func: Int => String, value: Int) = func(value)
  def paramFunc[A] (x: A) = "[" + x.toString + "]"
  def addTwo (value: Int): Int = value + 2
  def applyFuncOnRange (begin: Int, end: Int, func: Int => AnyVal): Unit = {
    for (i <- begin to end)
      println(func(i))
  }
  def transferMoney(money: Double, bankFee: Double => Double): Double =
    money + bankFee(money)
  def bankFee(amount: Double) = amount * 0.05
  def main(args: Array[String]): Unit = {
    // Now call all the methods with some real values
    println(testHOF(paramFunc, 10))
    println(quarterMaker(20))
    println(paramFunc(50))
    println(addTwo(77))
    println(applyFuncOnRange(1, 10, addTwo))
    println(transferMoney(100, bankFee))
  }
}
