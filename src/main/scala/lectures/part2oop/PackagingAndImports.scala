package lectures.part2oop

import exercises.part2oop.Writer
import playground.{Cindirella => Princess, PrinceCharming}


object PackagingAndImports extends App{
  // package members are accessible by their simple name
  val writer = new Writer("Daniel", "RockTheJVM", 2018)

  // Packages are in jierarchy
  // matching folder structure.

  // package object
  val princess = new Princess
  val prince = new PrinceCharming

  // default imports
  // automatically imported
  // java.lang
  // scala - Int, Nothing, Function...
  // scala.PreDef -- println, ??? imported from scala predef
}
