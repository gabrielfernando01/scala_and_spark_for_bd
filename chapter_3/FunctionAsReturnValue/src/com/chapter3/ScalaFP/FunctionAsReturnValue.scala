package com.chapter3.ScalaFP

object FunctionAsReturnValue {
  def transferMoney (money: Double) = {
    if (money > 1000)
      (money: Double) => "Dear customer, we are going to add following amount as Fee: " + money * 0.05
    else
      (money: Double) => "Dear customer, we are going to add following amount as Fee: " + money * 0.1
  }

  def main (args: Array[String]): Unit = {
    val returnedFunction = transferMoney(1500.0)
    println(returnedFunction(1500))   // Prints Dear customer, we are going to add following amount as Fee: 75.0
  }
}
