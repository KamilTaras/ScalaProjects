package lectures.part3Functional

object HOFnCurr extends App {
//  val superFun:(Int,(String,(Int=>Boolean)) => Int) =>(Int => Int) = ???
  //higher prder function (HOF)
  //  function which returns another function

  //  e.g. map, flatMap, filter in MyList

//  function that applies a function n times over a value x
//nTimes(f, n, x)
//nTimes(f, 3, x)

def nTimes(f: Int => Int, n: Int, x: Int):Int = {
  if (n<=0) x
  else nTimes(f, n-1, f(x))
}

  val plusOne = (x:Int) => x + 1
  println(nTimes(plusOne,10,1))

//  ntb(f,n) = x => f(f(f..(x)))
//increment10 - ntb(plusoOne,10) = x => plusOne(plusOne...(x))
//val y = increment10(1)

  def nTimesBetter(f: Int => Int, n:Int): (Int => Int) = {
    if (n<=0) (x:Int) => x
    else  (x:Int) => nTimesBetter(f,n-1)(f(x))
  }

  val plus10 = nTimesBetter(plusOne,10)
  println(plus10(1))

//  curried function
val supperAdder: Int => (Int => Int) = (x:Int) => (y:Int) => x + y

//functions with multiple parameter lists

def curriedFormatter(c:String)(x:Double): String = c.format(x)

val standardFormat: (Double => String) = curriedFormatter("%4.2f")
val preciseFormat: (Double => String) = curriedFormatter("%10.8f")

println((standardFormat(Math.PI)))
println((preciseFormat(Math.PI)))


}
