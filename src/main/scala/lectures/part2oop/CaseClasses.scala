package lectures.part2oop

object CaseClasses extends App{
  /*
    equals, hashCode, toString and companion objects
   */

  case class Person(name: String, age: Int)
  //1. class parameter are promoted to fields

  val jim = new Person("Jim", 34)
  println(jim.name)

  //2. sensible toString
  println(jim.toString)

  //3. equals and hashcode implemented out of the box
  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  //4. CCs have handy copy method
  val jim3 = jim.copy(age=45)
  println(jim3)

  //5. CCs have companion objects
  val thePerson = Person
  val mary = Person("Mary", 25)

  //6. Case classes are seralizable
  //Akka

  //7. CCs have extrator patterns = CCs can be used in PATTERN MATCHING

}
