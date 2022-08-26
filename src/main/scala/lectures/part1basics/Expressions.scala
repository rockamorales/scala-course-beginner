package lectures.part1basics

object Expressions extends App{
  val x = 1 + 2 //we call the right hand side an EXPRESSION
  println(x)

  println( 2 + 3 * 4)
  // Math Operators: + - * /
  // Bitwise operators: & | ^ << >> >>>(right shift with zero extension)

  //Relatinal operations: == != > >= < <=
  println( 1 == x)

  //Boolean operators:
  println(!(1==x))
  //! && ||

  //Other operators += -= *= /= -----> this are all side effects only work with variables -- var x

  //Intructions (DO) vs Expression (VALUE)

  // IF expression
  val aCondition = true
  val aConditionValue = if(aCondition) 5 else 3
  println(aConditionValue)

  //OLD loops (from JAVA), specific to imperative programs
  var i = 0
  while (i < 10) {
    println(i)
    i += 1
  }


  //Everything in scala is an EXPRESSION!

  var aVariable = 3
  val aWeirdValue = (aVariable = 3) //Unit === void
  println(aWeirdValue)

  // side effects: println(), whiles, reassigning

  //Code blocks
  val aCodeBlock = {
    val y = 2 //Scope: only visible inside this code block
    val z = y + 1 //Scope: only visible inside this code block

    if (z > 2) "hello" else "goodbye"
  }

  // val take the type of the last expression in the code block

  //1. what is the difference between "hello world" vs println("hello world)"?
  // A/ "hello world" is a value of type string. String literal
  // expression with side effect
  //2. what is the value of the following code
  val someValue = { // return true
    2 < 3
  }

  val someOtherValue = { // return 42
    if (someValue) 239 else 986
    42
  }

}
