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
  def filter(predicate: MyPredicate[A]): MyList[A]
  def map[B](transformer: MyTransformer[A, B]): MyList[B]
  def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B]

}

case object Empty extends MyList[Nothing] {
  def head: Nothing = throw new NoSuchElementException()
  def tail: MyList[Nothing] = throw new NoSuchElementException()
  def isEmpty: Boolean = true
  def add[B](newValue: B): MyList[B] = Cons(newValue, Empty)
  override def printElements: String = ""
  override def filter(predicate: MyPredicate[Nothing]): MyList[Nothing] = Empty
  override def map[B](transformer: MyTransformer[Nothing, B]): MyList[B] = Empty
  override def flatMap[B](transformer: MyTransformer[Nothing, MyList[B]]): MyList[B] = Empty
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

  override def filter(predicate: MyPredicate[A]): MyList[A] = {
    if (predicate.test(h)) Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  override def map[B](transformer: MyTransformer[A, B]): MyList[B] = {
     Cons(transformer.transform(h), t.map(transformer))
  }
  override def flatMap[B](transformer: MyTransformer[A, MyList[B]]): MyList[B] = {
    transformer.transform(h) ++ t.flatMap(transformer)
  }
}

trait MyPredicate[-T] {
  def test(elem: T): Boolean
}

trait MyTransformer[-A, B] {
  def transform(elem: A): B
}

object MyList extends App {
  val myList = new Cons[Int](1, Cons(2, Cons(3, Cons(4, Empty))))

  println(myList.filter(new MyPredicate[Int] {
    override def test(elem: Int): Boolean = elem % 2 == 0
  }).toString)
  println(myList.map(new MyTransformer[Int, Int] {
    override def transform(elem: Int): Int = elem * 2
  }).toString)
  println(myList.flatMap(new MyTransformer[Int, MyList[Int]] {
    override def transform(elem: Int): MyList[Int] = Cons(elem, Cons(elem + 1, Empty))
  }).toString)
  val emptyList = Empty
  println(emptyList.add(3).add(4).toString)

}