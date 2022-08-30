package lectures.part4pm

import scala.util.Random

object PatternMatching extends App {
  //switch on steroids
  val random = new Random()
  val x = random.nextInt(10)

  val description = x match {
    case 1 => "The one"
    case 2 => "double or nothing"
    case 3 => "third time is a charm"
    case _ => "Something else"
  }

  println(x)
  println(description)

  // 1. Decompose values
  case class Person(name: String, age: Int)

  val bob = Person("Bob", 20)

  //
  val greeting = bob match {
    case Person(n, a) if a < 21 => s"Hi, my name is $n and I can't drink in the US"
    case Person(n, a) => s"Hi, my name is $n and I am $a years old"
  }

  //1. cases are matched in order
  //2. if no case match a match error is thrown
  //3. Type is the unification of all types return in each in expression
  // will find the lowest common ancestor for all types returned in cases
  //PM works really well with case classes*

  //PM on sealed hierarchies
  sealed class Animal

  case class Dog(breed: String) extends Animal

  case class Parrot(greeting: String) extends Animal

  val animal: Animal = Dog("Terra nova")
  animal match {
    case Dog(someBreed) => println(s"Matched a dog of $someBreed breed")

  }


  //Match everything
  val isEven = x match {
    case n if n % 2 == 0 => true
    case _ => false
  }

  /*
    Exercise:
      Simple function that takes an expression and show a human readable string
      Sum(Number(2), Number(3)) => 2 + 3
      Sum(Number(2), Number(3), Number(4)) => 2 + 3 + 4
      Prod(Sum(Number(2), Number(1), Number(3) => (2 + 1) * 3
      Sum(Prod(Number(2), Number(1)), Number(3)) => 2 * 1 + 3
   */

  trait Expr

  case class Number(n: Int) extends Expr

  case class Sum(e1: Expr, e2: Expr) extends Expr

  case class Prod(e1: Expr, e2: Expr) extends Expr

  def show(expr: Expr): String = {
    expr match {
      case Number(n) => s"$n"
      case Prod(e1@Sum(_, _), e2@Number(_)) => s"( ${show(e1)} ) * ${show(e2)} "
      case Prod(e1@Number(_), e2@Sum(_, _)) => s"${show(e1)} * ( ${show(e2)} )"
      case Prod(e1@Sum(_, _), e2@Sum(_, _)) => s"(${show(e1)} ) * ( ${show(e2)} )"
      case Prod(e1, e2) => s"${show(e1)} * ${show(e2)}"
      case Sum(e1, e2) => s"${show(e1)} + ${show(e2)} "
    }
  }

  println(show(Sum(Number(2), Number(3))))
  //  => 2 + 3
  println(show(Sum(Number(2), Sum(Number(3), Number(4)))))
  //  //=> 2 + 3 + 4
  println(show(Prod(Sum(Number(2), Number(1)), Number(3))))
  //  //=> (2 + 1) * 3
  println(show(Sum(Prod(Number(2), Number(1)), Number(3))))
  //=> 2 * 1 + 3

}
