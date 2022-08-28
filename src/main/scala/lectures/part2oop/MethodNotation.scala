package lectures.part2oop

import scala.language.postfixOps

object MethodNotation extends App{

  class Person(val name: String, favouriteMovie: String, age: Int) {
    def likes(movie: String): Boolean = movie == favouriteMovie
    def +(person: Person): String = s"${this.name} is hanging out with ${person.name}"
    def +(alias: String): Person = new Person(s"${this.name} ($alias)", this.favouriteMovie, this.age)
    def unary_! : String = s"$name what the heck!"

    def isAlive(): Boolean = true

    def apply(): String = s"My name is $name and I like $favouriteMovie"

    def unary_+ : Person = new Person(this.name, this.favouriteMovie, this.age + 1)

    def learns(what: String): String = s"Mary learns $what"
    def learnsScala(): String = learns("Scala")

    def apply(times:Int): String = s"Mary watched $favouriteMovie $times times"
  }

    val mary = new Person("Mary", "Inception", 20)
    println(mary.likes("Inception"))
    println(mary likes "Inception") //Infix notation: only works with methods
                                    // which has only one parameter (called syntactic sugar)

    //"operators" in scala
    val tom = new Person("Tom", "FIght Club", 30)
  println( tom + mary)
  println( tom.+(mary))

  // All operators are methods

  // Prefix notation

  val x = -1
  val y = 1.unary_-
  //unary_prefix only works with a few operators: -, +, ~, !

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive())
  println(mary isAlive) //at least in scala 2.13 requires the import of the scala.language.postfixOps

  //Method apply
  println(mary.apply()) // normal method call
  println(mary())


}

/* Exercises
  1. Overload the + operator
    -- Example mary + "The rockstar" ==> new Person "Mary (The Rockstar)"

  2. add an age to the person
    add a unary + operator => new Person with age + 1
    +mary => Mary with the age incremented

  3. Add a "learns" method in the person class => "mary learns scala"
     Add a learnScala method, calls learns method with Scala
     Use it in postfix notation

  4. Overload the apply method
    mary.apply(2) => Mary watched inception 2 times


 */
