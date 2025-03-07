// =======================================================
// Companion object

class Animal {
  var animalName: String = "notset"
  var animalAge: Int = 0  // Agregar variable para la edad
  def setAnimalName(name: String) {
    animalName = name
  }
  def getAnimalName: String = {
    animalName
  }
  def isAnimalNameSet: Boolean = {
    if(getAnimalName == "notset") false else true
  }
  def setAnimalAge(age: Int) {  // Agregar método para establecer la edad
    animalAge = age
  }
  def getAnimalAge: Int = {     // Agregar método para obtener la edad
    animalAge
  }
}

object Animal {
  def main(args: Array[String]): Unit = {
    val obj: Animal = new Animal
    var flag: Boolean = false
    obj.setAnimalName("dog")
    flag = obj.isAnimalNameSet
    println(flag)     // prints true
    obj.setAnimalName("notset")
    flag = obj.isAnimalNameSet
    println(flag)   // print false
  }
}

object RunAnimalExample {
  val animalObj = new Animal
  println(animalObj.getAnimalName)    // prints the initial name
  println(animalObj.getAnimalAge)     // print the initial age
  // Now try setting the values of animal name and age as follows:
  animalObj.setAnimalName("dog")      // setting animal name
  animalObj.setAnimalAge(10)
  println(animalObj.getAnimalName)    // prints the new name of the animal
  println(animalObj.getAnimalAge)     // print the new age of the animal
}
