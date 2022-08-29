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

  def foreach(f: A => Unit): Unit

  def sort(f: (A, A) => Int): MyList[A]
  def zipWith[B, C](list: MyList[B], f: (A, B) => C): MyList[C]
  def fold[B >: A](start: B): ((A, B) => B) => B
  def fold1[B](start: B)(operator: (B, A) => B): B
//    (f:(x: C, y: C) => C ) =>

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

  override def foreach(f: Nothing => Unit): Unit = ()

  override def sort(f: (Nothing, Nothing) => Int): MyList[Nothing] = Empty

  override def zipWith[B, C](list: MyList[B], f: (Nothing, B) => C): MyList[C] = Empty

  override def fold[A](start: A): ((Nothing, Nothing) => A) => A =
    (f: ((Nothing, Nothing) => A)) => start
  def fold1[A](start: A)(f: (Nothing, Nothing) => A) =
    (f: ((Nothing, Nothing) => A)) => start

  override def fold1[B](start: B)(operator: (B, Nothing) => B): B = start
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

  override def foreach(f: A => Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  override def sort(compare: (A, A) => Int): MyList[A] = {
    def insert(x: A, sortedList: MyList[A]): MyList[A] = {
      if (sortedList.isEmpty) new Cons(x, Empty)
      else if(compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else Cons(sortedList.head, insert(x, sortedList.tail))
    }

    val sortedTail = t.sort(compare)
    insert(h, sortedTail)
  }

  override def zipWith[B, C](list: MyList[B], f: (A, B) => C): MyList[C] = {
    if(list.isEmpty) Cons(f(h, list.head), Empty)
    else Cons(f(h, list.head), t.zipWith(list.tail, f))
  }

  override def fold[B>:A](start: B): ( (A,B) => B) => B =
    (f: (A, B) => B) => t.fold(f(h,start))(f)

  override def fold1[B](start: B)(operator: (B, A) => B): B =
    t.fold1(operator(start,h))(operator)
}

object MyList extends App {
  val myList = new Cons[Int](1, Cons(2, Cons(3, Cons(4, Empty))))

  println(myList.filter(_ % 2 == 0).toString)
  println(myList.map(_ * 2).toString)
  println(myList.flatMap(x => Cons(x, Cons(x+1, Empty))).toString)
  val emptyList = Empty
  emptyList.add(3).add(4).foreach(println)
  val list = emptyList.add(3).add(4);
  println(emptyList.add(3).add(4).zipWith(list, (x: Int, y: Int) => x + y))
  println(emptyList.add(3).add(4).sort((x, y)=> x - y))
  println(emptyList.add(3).add(4).zipWith(list, (x: Int, y: Int) => x + y).fold(0)(_ + _))

  val anotherList = for {
    n <- list
    x <- myList
  } yield n * x

  println(anotherList)

}