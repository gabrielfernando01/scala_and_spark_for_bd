
// Definición de un Trait
trait Logger {
  def log(message: String): Unit = println(s"[LOG]: $message")
}

// Definición de otro Trait
trait Timestamp {
  def getTimestamp(): String = java.time.LocalDateTime.now().toString
}

// Clase que usa los Traits
class User(name: String) extends Logger with Timestamp {
  def printDetail(): Unit = {
    log(s"User: $name, Timestamp: ${getTimestamp()}")
  }
}

// Uso de la clase
object Log extends App {
  val user = new User("Cassandre")
  user.printDetail()
}


