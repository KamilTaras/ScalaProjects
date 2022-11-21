package lectures.part3Functional

object AnonymousFunctions extends App{

//  anonymous function
  val doubler: Int => Int = x => x*2
//  multiple parameters
  val adder: (Int, Int) => Int = (a,b) => a + b
//  no parameter
  val justDoSth: () => Int = () => 3


//be careful
  println(justDoSth)
  println(justDoSth())

//  curly braces with LAMBDA

  val stringToInt = { (str: String) =>
    str.toInt
  }


//  MOAR syntactic sugar
  val niceIncrementer:Int => Int = x => x+1
  val nicerIncrementer: Int => Int = _ + 1

  val niceAdder: (Int, Int) => Int = (a,b) => a+b
  val nicerAdder: (Int, Int) =>Int = _+_


  val supperAdd = (x: Int) => (y:Int) => x+y

}
