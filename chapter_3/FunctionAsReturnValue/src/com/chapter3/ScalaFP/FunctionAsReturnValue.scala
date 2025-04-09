package com.chapter3.ScalaFP

object FunctionAsReturnValue {
  // Define a function that takes an amount (money) and returns another function as a result.
  def transferMoney (money: Double) = {
    // If the initial amount is greater than 1000, returns a function that applies a 5% fee.
    if (money > 1000)
      // Anonymous function that takes a new amount and calculates the fee as 5% of that amount
      (money: Double) => "Dear customer, we are going to add following amount as Fee: " + money * 0.05
    else
      // If the initial amount is less than or equal to 1000, returns a function that applies a 10% fee
      (money: Double) => "Dear customer, we are going to add following amount as Fee: " + money * 0.1
  }

  def main (args: Array[String]): Unit = {
    // Call transferMoney with 1500.0 and save the returned function in returnedFunction
    val returnedFunction = transferMoney(1500.0)
    // Execute the returned function with the value 1500 and display the result
    println(returnedFunction(1500))   // Prints: "Dear customer, we are going to add following amount as Fee: 75.0"
  }
}
