
class Animal {
  var animalName: String = "notset"

  def setAnimalName(name: String) {
    animalName = name
  }

  def getAnimalName: String = {
    animalName
  }

  def isAnimalNameSet: Boolean = {
    if(getAnimalName == "notset") false else true
  }
}

object Animal {
  def main(args: Array[Strring]): Unit = {
    val obj: Animal = new Animal
    var flag: Boolean = false
    obj.setAnimalName("dog")
    flag = obj.isAnimalNameSet
    println(flag)
    obj.setAnimalName("notset")
    flag = obj.isAnimalNameSet
    println(flag)
  }
}


