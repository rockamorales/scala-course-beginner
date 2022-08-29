package exercises.part3fp

object Functions extends App{

  val concatenator = (v1: String, v2: String) => v1 + v2
  println(concatenator("Hello ", "World"))
}

class Function111 {
  def apply(v1: Int) = {
    (input: Int) => v1
  }
}
