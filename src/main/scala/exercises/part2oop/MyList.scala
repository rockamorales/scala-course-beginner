package exercises.part2oop

abstract class MyList[+A] {
  /*
    Single linked list
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add => receives an integer and returns a new list with element added
    toString => return a string representation of the list

   */
  def head: A
  def tail: MyList[A]
  def isEmpty: Boolean
  def add[B >: A](newValue: B): MyList[B]
  override def toString : String = s"[${printElements}]"
  def printElements: String
}

object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()

  def tail: MyList[Nothing] = throw new NoSuchElementException()

  def isEmpty: Boolean = true

  def add[B](newValue: B): MyList[B] = new Cons(newValue, Empty)

  override def printElements: String = ""

}
class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def isEmpty: Boolean = false

  override def add[B >: A](newValue: B): MyList[B]= new Cons(newValue, this)

  override def head: A = head

  override def tail: MyList[A] = tail

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
  }

  List(1,2,3) :+ 1
}