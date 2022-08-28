package lectures.part2oop

object Objects extends App{
  // Scala does not have class level functionality
  // does not know the concept of static

  object Person {
    // class level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    def from(mother: Person, father: Person) = new Person("Bobby")
    def apply(mother: Person, father: Person) = new Person("Bobby")
  }

  class Person (val name: String) {
    //instance-level functionality
  }


  // A pattern used often is to write the class and object in the same file with the same name
  // This pattern is called companions

  println(Person.N_EYES)
  println(Person.canFly)

  // Scala uses objects as a singleton instance
  // when an object is defined, we defined its type but also its only instance

  val mary = new Person("Mary")
  val john = new Person("John")
  println(mary == john)
}
