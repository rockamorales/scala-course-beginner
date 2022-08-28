package exercises.part2oop

class OOBasics extends App{

}

class Writer(firstName: String, surname: String, val year: Int){
  def fullName(): String = {
    return s"$firstName $surname"
  }
}

class Novel(name: String, yearOfRelease: Int, author: Writer){
  def authorAge(): Int = yearOfRelease - author.year
  def isWritternBy(author: Writer): Boolean = {
    return this.author == author
  }
  def copy(year: Int): Novel = {
    return new Novel(this.name, year, this.author)
  }
}

class Counter (val count: Int = 0) {

  def inc(): Counter = new Counter(count + 1)

  def dec(): Counter = new Counter(count - 1)

  def inc(amount: Int): Counter = new Counter(count + amount)

  def dec(amount: Int): Counter = new Counter(count - amount)
}

