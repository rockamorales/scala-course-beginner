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
  def ++[B >: A](newValues: MyList[B]): MyList[B]
  override def toString : String = s"[${printElements}]"
  def printElements: String
  def filter(predicate: A => Boolean): MyList[A]
  def map[B](transformer: A => B): MyList[B]
  def flatMap[B](transformer: A => MyList[B]): MyList[B]

}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()
  def tail: MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add[B](newValue: B): MyList[B] = Cons(newValue, Empty)
  override def printElements: String = ""
  override def filter(predicate: Nothing => Boolean): MyList[Nothing] = Empty
  override def map[B](transformer: Nothing => B): MyList[B] = Empty
  override def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  override def ++[B >: Nothing](newValues: MyList[B]): MyList[B] = newValues
}
case class Cons[+A](h: A, t: MyList[A]) extends MyList[A] {
  override def isEmpty: Boolean = false
  override def add[B >: A](newValue: B): MyList[B]= Cons(newValue, this)
  override def ++[B >: A](list: MyList[B]): MyList[B] = Cons(h, tail ++ list)
  override def head: A = h
  override def tail: MyList[A] = t
  override def printElements: String = {
    if (t.isEmpty) "" + h
    else s"$h ${t.printElements}"
  }

  override def filter(predicate: A => Boolean): MyList[A] = {
    if (predicate(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: A => B): MyList[B] = {
     Cons(transformer(h), t.map(transformer))
  }
  override def flatMap[B](transformer: A => MyList[B]): MyList[B] = {
    transformer(h) ++ t.flatMap(transformer)
  }
}

object MyList extends App {
  val myList = new Cons[Int](1, Cons(2, Cons(3, Cons(4, Empty))))

  println(myList.filter(_ % 2 == 0).toString)
  println(myList.map(_ * 2).toString)
  println(myList.flatMap(x => Cons(x, Cons(x+1, Empty))).toString)
  val emptyList = Empty
  println(emptyList.add(3).add(4).toString)

}