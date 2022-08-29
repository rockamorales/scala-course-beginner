package lectures.part2oop

object AbstractDataTypes extends App {
  // abstract members
  // classes that contains unimplemented abstract members are called abstract classes

  abstract class Animal {
    val creatureType: String
    def eat: Unit
  }

  //Abstract classes cannot be instantiated
  //val animal = new Animal ()


  // classes that inherits from abstract class must either implement all abstract methods
  // defined in the abstract classes or be an abstract classes themselves

  // Abstract classes can abstract and non abstract members

  class Dog extends Animal {
    override val creatureType: String = "Canine"
    override def eat: Unit = println("crunch crunch")
  }

  // Traits by default like abstract classes have abstract fields and methods
  // traits can have abstract and non abstract members
  // traits do not have constructor parameters
  // multiple traits may be inherits by the same class
  // traits = behavior, abtract classes is a type of thing

  trait Carnivore {
    def eat(animal: Animal): Unit
    val preferredMeal: String = "fresh meat"
  }

  trait ColdBlooded
  class Cocodrile extends Animal with Carnivore with ColdBlooded {
    override val creatureType: String = "croc"
    def eat: Unit = println("nomnom")
    def eat(animal: Animal): Unit = println(s"I'm a croc and I'm eating a ${animal.creatureType}")
  }

  val dog = new Dog
  val croc = new Cocodrile
  croc.eat(dog)

}
