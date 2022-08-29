package exercises.part2oop

abstract class MyList {
  /*
    Single linked list
    head = first element of the list
    tail = remainder of the list
    isEmpty = is this list empty
    add => receives an integer and returns a new list with element added
    toString => return a string representation of the list

   */
  def head: Int
  def tail: MyList
  def isEmpty: Boolean
  def add(newValue: Int): MyList
  override def toString : String = s"[${printElements}]"
  def printElements: String
}

object Empty extends MyList {
  def head: Int = throw new NoSuchElementException()

  def tail: MyList = throw new NoSuchElementException()

  def isEmpty: Boolean = true

  def add(newValue: Int): MyList = new Cons(newValue, Empty)

  override def printElements: String = ""

}
class Cons(h: Int, t: MyList) extends MyList {
  override def isEmpty: Boolean = false

  override def add(newValue: Int): MyList = new Cons(newValue, this)

  override def head: Int = head

  override def tail: MyList = tail

  override def printElements: String = {
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
  }

}
