
// Define a trait called "Flying"
trait Flying {
  def fly(): String = "I'm flying."   // Concrete method
  def land(): String                  // Abstract method (no implementation)
}

// Class that uses the trait
class Bird extends Flying {
  def land(): String = "I have landed softly."   // We implement the abstract method
}

// Uso del código
object Bird {
  def main(args: Array[String]): Unit = {
    val bird = new Bird()
    println(bird.fly())     // output: I'm flying.
    println(bird.land())    // output: I have landed softly.
  }
}


