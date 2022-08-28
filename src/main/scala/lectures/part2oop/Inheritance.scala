package lectures.part2oop

object Inheritance extends App{
  class Animal {
    val creatureType = "wild"
    protected def eat = println("nomnom")
  }

  class Cat extends Animal {
    def crunch = {
      eat
      println("Crunch Crunch")
    }
  }

  val cat = new Cat
  cat.crunch

  class Person(name: String, age: Int) {
    def this(name: String) = this(name, 0)
  }

  class Adult(name: String, age: Int, idCard: String) extends Person(name, age) {

  }
  class Adult1(name: String, age: Int, idCard: String) extends Person(name) {
  }

  //Fields have the special property that they can be overridden in the class parameters definition
  class Dog(override val creatureType: String) extends Animal {
    override def eat() = println("crunch crunch")
  }

  val dog = new Dog("domestic")
  dog.eat()
  println(dog.creatureType)

  val unknownAnimal = new Dog("K9")
  unknownAnimal.eat()

  //Overriding ==> supplying a different implementation in the overrides classes
  //Overloading ==> supplying multiple implementation of an specifc method in the same class

  //super: allows to call method on super class

  //Preventing overrides:
  //  1. Use final keyword at class level
  //  2. use final keyword for a class member
  //  3. use seal classes: allows subclasses only in the same file where the main class is defined


}
