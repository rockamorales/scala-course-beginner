package lectures.part3fp

import scala.util.Random

object Sequences extends App {
  //Seq
  val aSequence = Seq(1,3,2,4)
  println(aSequence)
  println(aSequence.reverse)
  println(aSequence(2))
  println(aSequence ++ Seq(7,5,6))
  println(aSequence.sorted)

  // Sorted method works if the type is by default ordered

  // Ranges
  val aRange: Seq[Int] = 1 until 10
  aRange.foreach(println)
  (1 to 10).foreach(x => println("Hello "))

  // lists
  val aList = List(1,2,3)
  val prepended = 42 :: aList
  val prepended1 = 42 +: aList :+ 89

  val apples5 = List.fill(5)("apple")
  println(apples5)

  println(aList.mkString("_|_"))


  //Arrays
  val numbers = Array(1,2,3,4)
  val threeElements = Array.ofDim[String](3)
  println(threeElements)
  threeElements.foreach(println)

  // Mutations
  numbers(2) = 0 // Syntax sugar for numbers.update(2, 0)
  println(numbers.mkString(" "))

  //Arrays and seq
  val numbersSeq: Seq[Int] = numbers // Implicit conversion
  println(numbersSeq)

  // Vectors
  val vector: Vector[Int] = Vector(1,2,3)
  println(vector)

  // vectors vs lists
  val maxRuns = 100000
  val maxCapacity = 100000000
  def getWriteTime(collection: Seq[Int]): Double = {
    val r = new Random
    val times = for {
      it <- 1 to maxRuns
    } yield {
      val currentTime = System.nanoTime()
      collection.updated(r.nextInt(maxCapacity), r.nextInt())
      System.nanoTime() - currentTime
    }
    times.sum * 1.0 / maxRuns
  }
  val numbersList = (1 to maxCapacity).toList
  val numbersVector = (1 to maxCapacity).toVector
  // keeps reference to tail
  // disadvantages: Updating an element in the middle takes a long time
  println(getWriteTime(numbersList))
  //depth of the tree is small
  // needs to replace an entire 32-element chunck
  println(getWriteTime(numbersVector))
}
