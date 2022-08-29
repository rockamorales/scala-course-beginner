package lectures.part2oop

import exercises.part2oop._


object Generics extends App {
  // we are chosing MyList to be co-variant
   class MyList[+A] {
    // use the type A inside the class definition
    def add[B >: A](element: B): MyList[B] = ???
    /*
      A = Cat
      B = Animal

     */
    // If I have a list of animals that is in fact a list of cats, can I add a new Dog to it, how?
    // Answer is: if we add a Dog to a list of cat then we need to turn the list of Cat into a list of animals

  }

  val listOfIntegers = new MyList[Int]
  val listOfStrings = new MyList[String]
  class MyMap[Key,Value]

  // generic methods

  //Object cannot be type parameterized
  object MyList {
    def empty[A]: MyList[A] = ???
  }

  // Variance problem
  class Animal
  class Cat extends Animal
  class Dog extends Animal

  // Question: is List[Cat] a List<Animal>?
  // 3 possible answers
  //   1. Yes. A List[Cat] is a List[Animal] <-- this is called covariant
  class CovariantList[+A]

  val animal: Animal = new Cat
  val animalList: CovariantList[Animal] = new CovariantList[Cat]
  // given that animalList is of Animals can I add a Dog instance? HARD QUESTION????

  //   2. No. List[Cat] and List[Animal] are two separate things <-- this is called invariant
  class InvariantList[A]
  // compilers will complain because List[Animal] is not the same as List[Cat]
  // does not compile --> val invariantListOfAnimals: InvariantList[Animal] = new InvariantList[Cat]

  //   3. Hell, no: CONTRAVARIANT
  class ContravarianList[-A]
  val contravarianList: ContravarianList[Cat] = new ContravarianList[Animal] // this does not make sense
  // because Animals can be Dogs and other animals

  // But it make sense in the following relationShip
  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]
  // Int the following case it does not make sense, because a trainer of Cat cannot train all animals
  // does not compile -> val trainer1: Trainer[Animal] = new Trainer[Cat]

  //Bounded Types
  //upper bounded
  class Cage[A <: Animal](animal: A)

  val cage = new Cage(new Dog)

// lower bounded
class Cage1[A >: Animal](animal: A)


  val myList = new Cons[Int](1, new Cons(2, new Cons(3, new Cons(4, Empty))))

  println(myList.filter(EvenFilter).toString)
  println(myList.map(DuplicateTransformer).toString)
  println(myList.flatMap(AnotherTransformer).toString)
  val emptyList = Empty
  println(emptyList.add(3).add(4).toString)
}
