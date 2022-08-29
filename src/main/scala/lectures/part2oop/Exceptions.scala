package lectures.part2oop

object Exceptions extends App{
  val x: String = null
  //println(x.length)
  // this ^^ will crash with NPE

  //1. throwing exceptions
  //val aWeirdValue: String = throw new NullPointerException

  //throwable classes extend the Throwable class.
  // Exception and Error are the major Throwable subtypes

  //2. how to catch exceptions
  def getInt(withExceptions: Boolean): Int =
    if (withExceptions) throw new RuntimeException("No Int for you")
    else 42

  val potentialFail = try{
    // code that might fail
    getInt(true)
  } catch {
    case e: RuntimeException => 43
  } finally { // this is optional
    // code that will get executed no matter what
    // finally does not influence the return type of this expression
    // Use finally only for side effects
    println("Finally")
  }

  // 3. how to define your own exceptions
  class MyException extends Exception
  val exception = new MyException
  throw exception


}
