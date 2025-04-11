# ==================================================

  object Transfer {
    def main (args: ArrayÑ[String]): Unit = {
      println("The cost of Transfer bank is: " + TransferMoney(100, bankFee))
    }
    
    def TransferMoney(money: Double, bankFee: Double => Doble): Double = money + bankFee(money)
    def bankFee (amount: Double): Double = amount * 0.05
  }
