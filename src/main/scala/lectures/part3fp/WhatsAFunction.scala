package lectures.part3fp

object WhatsAFunction extends App{

  //Use and work with functions as first class elements
  //Problem: we come from oop world, everything is an instance of a class
  val doubler = new MyFunction[Int, Int] {
    override def apply(element: Int): Int = element * 2
  }

  println(doubler(2))

  // Scala function types
  val stringToIntConverter = new Function1[String, Int] {
    override def apply(v1: String): Int = v1.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder = new Function2[Int, Int, Int] {
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  // Syntactic sugar
  // Function2[A,B,R] === (A,B) => R

  //ALL SCALA FUNCTIONS ARE OBJECTS

}

trait MyFunction[A, B] {
  def apply(element: A): B = ???
}

/* Exercises
   1. a function which takes 2 string and concatenates them
   2. transform the MyPredicate and MyTransformer into function types
   3. define a function which takes an Int and returns another function which takes and Int and returnes and Int
      --what's the types of this function
      --how to do it
 */

