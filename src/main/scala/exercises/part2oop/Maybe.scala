package exercises.part2oop

import java.util.NoSuchElementException

sealed abstract class Maybe[+A] {
  def get(): A
  def map[B](f: A => B): Maybe[B]
  def flatMap[B](f: A => Maybe[B]): Maybe[B]
  def filter(f: A => Boolean): Maybe[A]
}

 case object MaybeNot extends Maybe[Nothing] {
  override def get(): Nothing = throw new NoSuchElementException

  override def map[B](f: Nothing => B): Maybe[Nothing] = MaybeNot

  override def flatMap[B](f: Nothing => Maybe[B]): Maybe[Nothing] = MaybeNot

  override def filter(f: Nothing => Boolean): Maybe[Nothing] = MaybeNot
}

case class Just[+A](elem: A) extends Maybe[A] {
  override def get(): A = elem

  override def map[B](f: A => B): Maybe[B] =
    Just(f(elem))

  override def flatMap[B](f: A => Maybe[B]): Maybe[B] =
    f(elem)

  override def filter(f: A => Boolean): Maybe[A] =
    if (f(elem)) this
    else MaybeNot
}

object MaybeTest extends App {
  val just3 = Just(3)
  println(just3)
  println(just3.map(_ * 2))
  println(just3.flatMap(x => Just(x % 2 == 0)))
  println(just3.filter(_ % 2 == 0))
}


