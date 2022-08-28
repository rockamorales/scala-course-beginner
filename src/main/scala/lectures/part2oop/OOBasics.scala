package lectures.part2oop

object OOBasics extends App{
  val person = new Person("John", 26)
  println(person.age)
  person.greet("Jose")
}

// class parameters are not necessary class members
// If you want to make a class parameter also a field, use the keyword val
class Person(name: String, val age: Int) {
  //body
  // can have
  // fields
  // methods
  // expressions

  val x = 2
  def greet(name: String): Unit = println(s"${this.name} says: Hi, $name")

  //overloadig: Creating methods with the same name but different set of parameters
  def greet(): Unit = println(s"Hi, I am $name")

  //Multiple constructors
  def this(name: String) = this(name, 0)
  def this() = this("John Doe")
}

/* Exercises:
  1. Novel and Writer class
    a. Writer should have firstName, surname, year
       -- method fullname
    b. Novel: name, year of release, author
      --authorAge: age of the author at the year of release
      --isWrittenBy(author)
      --copy (new year of release) = new instance of novel

  2. Counter class
    -- Receives an int value
    -- method current count
    -- method to increment or decrement the counter by 1 => creates a new counter
    -- overload inc and dec method to receives a parameter which is the amount
    -- by which you increment or decrement counter

 */

