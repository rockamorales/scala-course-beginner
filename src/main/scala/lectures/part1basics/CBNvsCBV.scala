package lectures.part1basics

object CBNvsCBV extends App{

  def calledByValue(x: Long): Unit = {
    println("by value: " + x)
    println("by value: " + x)
  }

  def calledByName(x: => Long): Unit = {
    println("by name: " + x)
    println("by name: " + x)
  }

  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

  //By Value call, the exact value of the expression is computed before the function evaluates

  //By name call: The expression is passed literally as is, and the expression is evaluated every time
  // the argument is referenced
  // => delays the evaluation of the expression passed as parameters until the parameter is referenced
  //

  def infinite(): Int = 1 + infinite()

  def printFirst(x: Int, y: => Int) = println(x)

//  printFirst(34, infinite)
  printFirst(infinite(), 34)

}
