package lectures.part3fp

object AnonymousFunctions extends App {

  //Object oriented way
  val doubler = new Function1[Int, Int] {
    override def apply(v1: Int): Int = v1 * 2
  }

  // Scala syntactic sugar for a more functional way
  val doubler1 = (x: Int) => x * 2

  //Multiple params in a lambda
  val adder: (Int, Int) => Int = (a, b) => a + b

  //no params
  val justDoSomething: () => Int = () => 3

  // When you call lambdas, you must use parenthesis
  println(justDoSomething) // Function itself
  println(justDoSomething()) // call

  // curly breaces with lambdas
  val stringToInt = {(str: String) =>
    str.toInt
  }

  //More syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 //Equivalente to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _
}

/* Exercises
  1. MyList: replace all functionX calls with lambdas
  2. Rewrite the "special" adder as an anonymous functions
 */
