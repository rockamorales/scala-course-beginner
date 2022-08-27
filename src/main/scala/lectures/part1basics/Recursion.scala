package lectures.part1basics

object Recursion extends App {
  def factorial(n: Int): Int =
    //In order to run a recursive function the JVM uses a call stack to keep partial
    // results so it can go back to compute the final result
    if (n <= 1) 1
    else{
      println(s"Computing factorial of $n - I first need the factorial of ${n - 1 }")
      val result = n * factorial(n - 1)
      println(s"Computed factoial of $n")
      return result
    }

  //Why does anotherFactorial work with big numbers and does not throw a stackoverflow exception?
  // The trick of anotherFactorial is that we make the recursive call as the last expression.
  // So that allow scala to preserve the same stack frame and not use additional stack frames for
  // the recursive call. THIS IS CALLED: TAIL RECURSION. You can add @tailrec annotation to tell the
  // compiler to validate that a function a tail rec, if not tail rec, compiler will complain
  def anotherFactorial (n: Int): BigInt = {
    def factHelper(x: Int, acc: BigInt): BigInt = {
      if (x <= 1) acc
      else factHelper(x - 1, acc * n)
    }
    factHelper(n, 1)
  }
  println(factorial(10))
  println(anotherFactorial(5000))

  // WHEN YOU NEED LOOPS, USE _TAIL_ REC
  /* EXERCISES:
    1. Concatenate a String n times
    2. IsPrime function tail recursive
    3. Fibonacci function, tail recursive

    
   */
}
