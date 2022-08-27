package lectures.part1basics

object DefaultArgs extends App{

  def trFact(n: Int, acc: Int = 1): Int =
    if (n<=1) acc
    else trFact(n-1, n*acc)

  val fact10 = trFact(10, 2)
  val fact20 = trFact(20)
  val fact30 = trFact(30)
  println(fact10)
  println(fact20)
  println(fact30)

  def savePicture(format: String = "jpg", width: Int = 1920, height: Int = 1080): Unit = println("saving picture")

  //named parameters
  // savePicture(800) //compiler assumes the only parameter passed here is for the first argument

  // Solutions:
  // 1. pass int every leading argument
  // 2. name the arguments

  savePicture(width = 800)
}
