package exercises

import scala.annotation.tailrec

object Functions extends App{
  def greeting(name: String, age: Int): String = {
    s"Hi, my name is $name and I am $age years old"
  }

  @tailrec
  def factorial(n: Int, acc: Long = 1): Long = {
    if (n == 1) acc
    else factorial(n-1, acc * n)
  }

  def fibonacci(n: Int): Long = {
    @tailrec
    def calcFib(n1:Int, prev1: Long, prev2: Long): Long ={
      if (n1 > n) prev1
      else if (n1 == 1) calcFib(n1 + 1, 1, 0)
      else if (n1 == 2) calcFib(n1 + 1, 1, prev1)
      else calcFib(n1 + 1, prev1 + prev2, prev1)
    }
    calcFib(1, 0, 0)
  }

  def isPrime(n: Int): Boolean = {
    @tailrec
    def isPrimeUntil(n1: Int): Boolean = {
      if (n1 == 1) true
      else if (n%n1 == 0) false
      else isPrimeUntil(n1 - 1)
    }
    isPrimeUntil(n/2);
  }

  println(factorial(5))
  println(fibonacci(8))
  println(isPrime(37))
  println( isPrime(2003))
  println(isPrime(2))
  println(isPrime(3))
  println(isPrime(4))
  println(isPrime(5))
  println(isPrime(6))
  println(isPrime(7))
  println(isPrime(8))
  println(isPrime(9))

}
