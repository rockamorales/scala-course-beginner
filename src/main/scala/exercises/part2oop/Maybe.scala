package exercises.part2oop

abstract class Maybe[+A] {
  def get(): A
  def map[B](f: A => B): Maybe[B]
  def flatMap[B](f: A => Maybe[B]): Maybe[B]
  def filter(f: A => Boolean): Maybe[A]
}

object Empty extends Maybe[Nothing] {
  override def get(): Nothing = throw NoSuchElementException

  override def map[B](f: Nothing => B): Maybe[Nothing] = Empty

  override def flatMap[B](f: Nothing => Maybe[B]): Maybe[Nothing] = Empty

  override def filter(f: Nothing => Boolean): Maybe[Nothing] = Empty
}

case class Some[+A](elem: A) extends Maybe[A] {
  override def get(): A = elem

  override def map[B](f: A => B): Maybe[B] =
    Some(f(elem))

  override def flatMap[B](f: A => Maybe[B]): Maybe[B] =
    f(elem)

  override def filter(f: A => Boolean): Maybe[A] =
    if (f(elem)) this
    else Empty
}


