// Definimos un trait llamado "Volador"
trait Volador {
  def volar(): String = "Estoy volando"  // Método concreto
  def aterrizar(): String               // Método abstracto (sin implementación)
}

// Clase que usa el trait
class Pajaro extends Volador {
  def aterrizar(): String = "He aterrizado suavemente"  // Implementamos el método abstracto
}

// Uso del código
object Ave {
  def main(args: Array[String]): Unit = {
    val pajaro = new Pajaro()
    println(pajaro.volar())      // Salida: Estoy volando
    println(pajaro.aterrizar())  // Salida: He aterrizado suavemente
  }
}


