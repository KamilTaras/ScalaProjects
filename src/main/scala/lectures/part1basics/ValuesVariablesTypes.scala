package lectures.part1basics

import scala.language.postfixOps

object ValuesVariablesTypes extends App {
  val x : Int = 42
  println(x)
//  x  = 4 won't work
  var i: Int = 42
  i = i + 1
  println(i)
// compiler can infer types

}
