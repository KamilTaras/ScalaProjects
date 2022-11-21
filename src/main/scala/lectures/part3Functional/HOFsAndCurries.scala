package lectures.part3Functional

object HOFsAndCurries extends App {

//  val superFunction: (Int, (String, (Int => Boolean)) => (Int => Int)) = ???
  // Higher order function (HOF)

  //map, flatMap, filter in MyList

  //function that applies a function n times over a value x
  //  nTimes (f, n, x)
  //  nTimes(f,3,x) = f(f(f(x)))

  def nTimes(f: Int => Int, n: Int, x: Int): Int = {
    if (n <= 0) x
    else nTimes(f, n - 1, f(x))
  }


  val plusOne = (x:Int) => x+1
  println(nTimes(plusOne,10,1))



  def nTimesBettter(f:Int => Int, n:Int): (Int => Int) ={
    if ( n<= 0) (x:Int) => x
    else (x:Int) => nTimesBettter(f, n-1)(f(x))
  }

  val plus10 = nTimesBettter(plusOne,10)
  println(plus10(1))


//  curried functions

  val superAdder = (x:Int) => (y:Int) => x+y
  val add3 = superAdder(3)
  println(add3(10))

  println(superAdder(3)(10))
  def curriedFormatter (c:String)(x:Double):String = c.format(x)

}