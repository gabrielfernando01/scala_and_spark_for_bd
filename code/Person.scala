class Person(val name: String, val age: Int) {
  def showInfo(): Unit = {
    println("Name: " + name + ", Age: " + age + "...")
  }
}

object Person {
  def main(args: Array[String]): Unit = {
    val person = new Person("Gabriel", 43)
    person.showInfo()
  }
}
