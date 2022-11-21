package lectures.part1basics

import scala.jdk.Accumulator


def factorial (n: Int):Int= {
  if (n <= 1) 1
  else {
    println("Computing factorial of " + n + " - I first need factorial of " + (n-1))
    val result: Int= n*factorial(n-1)
    println("Computing factorial of " + n )

    result
  }
}

def anotherFactorial(n: BigInt): BigInt = {
  def factHelper (x: BigInt, accululator: BigInt): BigInt = {
    if (x<= 1) accululator
    else factHelper(x-1, x* accululator)
  }
  factHelper(n,1)
}

def concat(aString: String, n: Int): String={
  concat(aString, n-1, aString)
}

def concat(aString: String, n: Int, accumulator: String): String = {
  if (n <=0) accumulator
  else concat(aString, n-1, accumulator + aString)
}

//concatenate
//isPrime function tail recursive
//fibonacci function, tail recursion

def isPrimex(n:Int): Boolean = {

  def helpFunction(t:Int):Boolean = {
    if (t <=1) true
    else  (n%t != 0) && helpFunction(t-1)
  }

  if (n <=1) false
  else helpFunction(n/2)

}



object Recursion extends App {
  println(factorial(10))
  println(concat("Duppa", 4))
  println(isPrimex(-1))
  println(isPrimex(0))
  println(isPrimex(1))
  println(isPrimex(2))
  println(isPrimex(3))
  println(isPrimex(4))


}
