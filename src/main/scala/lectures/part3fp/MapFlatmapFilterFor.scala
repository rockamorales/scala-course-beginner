package lectures.part3fp

object MapFlatmapFilterFor extends App{
  val list = List(1,2,3)
  println(list.head)
  println(list.tail)

  // map
  println(list.map(_ + 1))
  println(list.map(_ + " is a number"))

  //filter
  println(list.filter(_ % 2 == 0))

  //flatMap
  val toPair = (x: Int) => List(x, x+1)
  println(list.flatMap(toPair))

  // Try to print all combinations of elements between 2 list
  val numbers = List(1,2,3,4)
  val chars = List('a', 'b', 'c', 'd')
  val colors = List("black", "white")
  val combined = chars.flatMap(x => numbers.map(y => x +""+ y))
  val combined1 = chars.flatMap(x => numbers.flatMap(y => colors.map(c => x +""+ y + c)))
  println(combined)
  println(combined1)

  // foreach
  list.foreach(println)

  // for-comprehensions
  val forCombinations = for {
    n <- numbers if n % 2 == 0 // with a guard
    c <- chars
    color <- colors
  } yield "" + c + n + "-" + color

  println(forCombinations)

  // doing side effects with for-comprehensions
  for {
    n <- numbers
  } println(n)

  // Syntax overload
  list.map { x =>
    x * 2
  }

  /*
    1. MyList supports for comprehensions?
    2. A small collection of at most ONE element - Maybe[+T] -> Subtypes empty collection or an element with one element
       of type T contained
      - map, flatMap, filter
   */
}
