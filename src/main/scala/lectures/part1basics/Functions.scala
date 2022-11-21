package lectures.part1basics

object Functions extends App {

  def aFunction (a: String,  b:Int):String = {
    a + " " + b
  }

  println(aFunction("Lil", 4))

  def aParameterFunction(): Int = 42

  println(aParameterFunction())


  def aRepeatedFunction(aString: String, n: Int): String ={
    if (n ==1) aString
    else aString + aRepeatedFunction(aString, n-1)
  }

  println(aRepeatedFunction("URBAN ZDECHŁ XD  ", 3))


  def aFunctionWithSideEffects(aString: String): Unit = println(aString)


  def aBigFunction (n:Int): Int = {
    def aSmallerFunction (a: Int, b:Int): Int = a+b

    aSmallerFunction(n, n-1)
  }

  greetings("Jerzy", 58)

  println(factorialFunction(10))

  println(fibonacciFunction(8))
  println(isPrime(100))

  def isPrime(n:Int) :Boolean = {
    def isPrimeUntil(t: Int) : Boolean ={
      if (t <= 1) true
      else (n % t != 0) && isPrimeUntil(t - 1)
    }

      isPrimeUntil(n / 2)
  }

}

def greetings (name:String, age:Int): Unit = println("Hi, my name is  " + name + " and I am  " + age + " years old")

def factorialFunction(n:Int) : Int = {
  if (n==1) 1
  else factorialFunction(n-1) * n
}
// if n (n<= 0) 1
//else n * factorialFunction(n-1)

def fibonacciFunction (n: Int) : Int = {
  if (n <= 2) 1
  else fibonacciFunction(n-1) + fibonacciFunction(n-2)
}

def isPrime(n: Int):Boolean ={
  def isPrimeUntil(i: Int ): Boolean = {
    if (i <=1) true
    else n%i != 0 && isPrimeUntil(i-1)
  }
  isPrimeUntil(n/2)
}


