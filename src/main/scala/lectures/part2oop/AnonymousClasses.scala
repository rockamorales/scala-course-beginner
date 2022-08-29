package lectures.part2oop

object AnonymousClasses extends App{
  abstract class Animal {
    def eat: Unit
  }

  val funnyAnimal = new Animal {
    override def eat: Unit = println("hahahahaha")
  }

  println(funnyAnimal.getClass)

  class Person(name: String) {
    def sayHi: Unit = println(s"Hi, my name is $name, how can I help?")
  }

  val jim = new Person("Jim"){
    override def sayHi: Unit = println(s"Hi, my name is Jim, how can I be of service?")
  }


  /* Exercises
    1. Generic trait MyPredicate[T]
       -- method which test if T passes that condition

    2. Generic trait MyTransFormer[A, B]
       -- Method to convert a value of type B to a value of type B

    3. MyList:
       map(transformer) => MyList transformed
       filter(predicate => MyList filtered
       flatMap(transformer from A to MyList[B]) => MyList[B]

    class EvenPredicate extends MyPredicate[Int]
    class StringToIntTransformer extends MyTransformer[String, Int]

    [1,2,3].map(n * 2) = [2,4,6]
    [1,2,3,4].filter(n % 2) = [2, 4]
    [1,2,3].flatMap(n => [n, n+1]) => [1,2,2,3,3,4]




   */
}
