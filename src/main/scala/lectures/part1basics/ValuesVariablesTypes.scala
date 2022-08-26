package lectures.part1basics

object ValuesVariablesTypes extends App{
  val x = 42
  println(x)

  // VALS ARE INMUTABLE
  // Type of VALS are optional. Compiler can infer the type from the right hand side

  val aString: String = "hello"
  val anotherString = "goodbye"

  //Basic Types
  val aBoolean: Boolean = false //true | false
  val aChar: Char = 'a'
  val anInt: Int = x
  val aShort: Short = 4123 //
  val aLong: Long = 43434343434343434L

  val aFloat: Float = 2.0f
  val aDouble: Double = 3.14

  //Variables can be reasigned
  var aVariable: Int = 4
  aVariable = 5 // Used for side effects

}
