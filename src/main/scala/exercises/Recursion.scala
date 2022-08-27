package exercises

import scala.annotation.tailrec

object Recursion extends App{
  @tailrec
  def concatenate(str: String, n: Int, acc: String = ""): String =
    if (n==1) acc
    else concatenate(str, n-1, acc + str)

  //check if a number is prime by doing a modulus operation with all positive numbers below n/2
  def isPrime(n: Long): Boolean = {
    @tailrec
    def isPrimeUntil(n1: Long): Boolean = {
      if (n1 == 1) true
      else if (n % n1 == 0) false
      else isPrimeUntil(n1 - 1)
    }
    isPrimeUntil(n / 2);
  }

  //print all primes from 1 to n
  def printPrimesUntil(n: Long, counter: Int = 0): Int = {
    var localCount = 0;
    if (n == 1) {
      //println(1)
      counter
    }
    else {
      if (isPrime(n)) {
        //println(n)
        localCount += 1
      }
      printPrimesUntil(n - 1, localCount + counter)
    }
  }


  // Find all primes up to certain number specified as paraneters
  // the primes set with default value, is intended for keeping track
  // of the primes that has been determined to be prime, but this method
  // is somehow 1000 times slower than the printPrimesUntil method above
  @tailrec
  def findPrimeNumbersUpToSqrt(n: Long, primes:Set[Long] = Set()): Set[Long] = {
    var localPrimes:Set[Long] = primes
    if (n==1) this.primes
    else {
      if (!primes.contains(n)) {
        if (this.primes.contains(n) || isPrimeSqrt(n)) {
          localPrimes += n
        }
      }
      this.primes = this.primes ++ localPrimes
      findPrimeNumbersUpToSqrt(n-1, localPrimes)
    }
  }
  var primes:Set[Long] = Set();

  // Determine if a number is prime, based on the theory that all the factors of a prime number n
  // are below sqrt(n)
  def isPrimeSqrt(n: Long): Boolean = {
    val primesUpTo = 2
    @tailrec
    def isDivisibleByAnyPrimeBelow(primesUpTo: Set[Long]): Boolean = {
      if(primesUpTo.size == 0) false
      else if ((n%primesUpTo.head) == 0) true
      else isDivisibleByAnyPrimeBelow(primesUpTo.tail)
    }

    val primesUpto = findPrimeNumbersUpToSqrt(Math.sqrt(n).toInt, primes);
    primes = primes ++ primesUpto
    !isDivisibleByAnyPrimeBelow(primesUpto);
  }

  //Uses the method: https://en.wikipedia.org/wiki/Sieve_of_Eratosthenes
  //Incredible fast to calculate a large number of element. But triggers out of memory when trying
  //to find numbers in the order of billions
  def findPrimesSieveOfErastothenes(n: Int): Int = {
    var primeErastothenes = Array.fill(n)(true);

    def markProductsOfP(p: Int, x: Int): Unit = {
      if (p * x < n) {
        primeErastothenes(p * x) = false
        markProductsOfP(p, x + 1)
      }
    }

    def processFactorsOfP(p: Int = 2): Unit = {
      if (p <= Math.sqrt(n)) {
        markProductsOfP(p, 2)
        processFactorsOfP(primeErastothenes.indexOf(true, p + 1))
      }
    }

    processFactorsOfP()

    var counter = 0
    def printPrimes(numbers: Seq[Boolean]): Long = {
      var index = 0
      var counter = 0
      numbers.foreach(x => {
        if(x && index > 0) {
          counter += 1
          println(index)
        }
        index += 1
      })
      counter
    }

    printPrimes(primeErastothenes)
//    primeErastothenes.zipWithIndex.foreach(x => {
//      if (x._1 && x._2 > 0) {
//        counter += 1
//        println(x._2)
//      }
//    })
    counter
  }


  //Fibonacci
  def fibonacci(n: Int): Long = {
    @tailrec
    def calcFib(n1: Int, prev1: Long, prev2: Long): Long = {
      if (n1 > n) prev1
      else calcFib(n1 + 1, prev1 + prev2, prev1)
    }

    calcFib(3, 1, 1)
  }

  // Print the primes using the method findPrimeNumbersUpToSqrt
  // Uses the sqrt theorem
  def printPrimesUntil1(n: Long): Int = {
    val primes1: Set[Long] = findPrimeNumbersUpToSqrt(n, primes)
    //for (prime <- primes1) println(prime)
    primes1.size
  }

  //  println(concatenate("Hello", 10))
  //  println(isPrime(10))
  //  println(isPrime(2003))
  //  println(isPrime(13*9))
  //  println(fibonacci(5))
  //  println(fibonacci(8))

//  val start = System.nanoTime()
//  val counter = printPrimesUntil1(10000L)
//  val end = System.nanoTime()
//  println(s"Total time: ${(end - start) / 1000000000} secs")
//  println(s"Total time: ${(end - start) / 1000000} milliseconds")
//  println(s"Total primes: " + counter)
//
//  val start1 = System.nanoTime()
//  val counter1 = printPrimesUntil(10000L)
//  val end1 = System.nanoTime()
//  println("----------------------------------------------")
//  println(s"Total time: ${(end1 - start1) / 1000000000} secs")
//  println(s"Total time: ${(end1 - start1) / 1000000} milliseconds")
//  println(s"Total primes: " + counter1)


  val start2 = System.nanoTime()
  val counter2 = findPrimesSieveOfErastothenes(1000000000)
  val end2 = System.nanoTime()
  println("----------------------------------------------")
  println(s"Total time: ${(end2 - start2) / 1000000000} secs")
  println(s"Total time: ${(end2 - start2) / 1000000} milliseconds")
  println(s"Total primes: " + counter2)

}
