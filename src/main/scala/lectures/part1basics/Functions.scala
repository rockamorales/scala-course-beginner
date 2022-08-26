package lectures.part1basics

object Functions extends App{
  def aFunction(a: String, b: Int): String =
    a + " " + b

  def aFunctionBlock(a: String, b: Int): String = {
    a + " " + b
  }

  //Calling a function is also an expression

  println(aFunction("hello", 3))

  //Parameterless functions can be called without parenthesis
  def aParameterlessFunction(): Int = 42
  println(aParameterlessFunction())
  println(aParameterlessFunction)

  def aRepeatedFunction(aString: String, n: Int): String = {
    if(n == 1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("hello", 3))

  //when you need loops, use recursion
  // Return type of a function can be inferred

  //Recursive functions require a return type

  //
  def aFunctionWithSideEffects(aString: String): Unit = println(aString)

  // code blocks also allow you to define auxiliary functions inside
  def aBigFunction(n: Int): Int = {
    def aSmallerFunction(a: Int, b: Int): Int = a + b
    aSmallerFunction(n, n-1)
  }

  //Exercises
  // 1. A greeting function for kids: takes two params (name, age) => "Hi, my name is $name and I am $age years old"
  // 2. Factorial function 1 * 2 * 3 * .. * n
  // 3. A fibonacci function
  //    f(1) = 1
  //    f(2) = 1
  //    f(n) = f(n - 1) + f(n - 2)
  // 4. check if a given

}
