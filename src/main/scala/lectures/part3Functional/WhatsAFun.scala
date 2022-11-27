package lectures.part3Functional

object WhatsAFun extends App {

//  val doubler = new MyFunction[Int, Int]{
//    override def apply(element: Int): Int = element * 2
//  }
//
//  println(doubler(2))

  //function types = Function1[A,B]
  val stringToIntConverter = new Function1[String, Int]{
    override def apply (string: String): Int = string.toInt
  }

  println(stringToIntConverter("3") + 4)

  val adder: Function2[Int, Int, Int]  = new Function2[Int, Int, Int]{
    override def apply(v1: Int, v2: Int): Int = v1 + v2
  }

  val concat: (String, String) => String = (v1: String, v2: String) => v1 + v2

//    Function  types Function2[A, B, R] === (A,B) => R

  val supperAdder: Function1[Int, Function1[Int,Int]] = new Function1[Int, Function1[Int,Int]]{
    override def apply(x: Int): Function1[Int, Int] = new Function1[Int, Int] {
      override def apply(y: Int): Int = x + y
    }
  }
  val supperAdder2: Int => Int => Int = (x: Int) => (y: Int) => x + y

  //All SCALA FUNCTIONS ARE OBJECTS

val adder3 = supperAdder(3)
println(adder3(4))
}

trait MyFunctionXdd[A,B] {
  def apply (element:A): B
}
