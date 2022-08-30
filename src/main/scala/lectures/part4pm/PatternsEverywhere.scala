package lectures.part4pm

object PatternsEverywhere extends App {
  //big idea #1
  try {
    // code
  } catch {
    case e: RuntimeException => "runtime"
    case npe: NullPointerException => "npe"
    case _ => "something else"
  }

  //catches are actually matches => equivalent to the following code

  //  try {
  //    // code
  //  } catch (e) {
  //        e match {
  //          case e: RuntimeException => "runtime"
  //          case npe: NullPointerException => "npe"
  //          case _ => "something else"
  //        }
  //  }

  //big idea #2
  val list = List(1,2,3,4)
  val evenOnes = for {
    x <- list if x % 2 == 0 // generator -- ?!
  } yield 10 * x

  // generators are also based on PATTERN MATCHING
  val tuples = List((1,2), (3,4))
  val filterTuples = for {
    (first, second) <- tuples
  } yield first * second
  // case classes, :: operator, ...

  // big idea #3
  val tuple = (1,2,3)
  val (a,b,c) = tuple
  println(a)
  // Multiple value definition based on pattern matching

  // ALL the power is available
  val head :: tail = list
  println(head)
  println(tail)

  // big idea # 4 - NEW
  // partial function
  val mappedList = list.map {
    case v if v % 2 == 0 => v + "is even"
    case 1 => "the one"
    case _ => "Something else"
  }

  val mappedList2 = list.map (x => x match {
    case v if v % 2 == 0 => v + "is even"
    case 1 => "the one"
    case _ => "Something else"
  })


}
