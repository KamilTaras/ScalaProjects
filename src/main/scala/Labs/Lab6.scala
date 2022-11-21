package Labs

//Task 1
def fibboRecurs(n:Int):Int = {
  def fibboHelp(n:Int, prevVal:Int,prevPrevValue: Int): Int ={
    if (n <= 0) 0
    else if (n == 1|| n==2) prevVal + prevPrevValue
    else fibboHelp(n-1,prevVal+ prevPrevValue, prevVal)
  }
  fibboHelp(n,1,0)
}

def fibboIteration(n: Int): Int = {

  if (n<=0) return 0
  else {
    var i = 0
    var prevVal = 1
    var prevPrevVal = 0
    var temp = 0

    while (i < n) {
      temp = prevVal
      prevVal = prevPrevVal + prevVal
      prevPrevVal = temp
      i += 1
    }
    prevPrevVal
  }
  }

//Task 2
class MathCalculationException extends RuntimeException

def divide(x: Double, y: Double):Double = if (y == 0) throw new MathCalculationException() else x/y


object Lab6 extends App {

  println("Task 1 \n Fibonacci - Recursion")

  print(fibboRecurs(0))
  print(fibboRecurs(1))
  print(fibboRecurs(2))
  print(fibboRecurs(3))
  print(fibboRecurs(4))
  print(fibboRecurs(5))
  println(fibboRecurs(6))



  println("Fibonacci - Iteration")
  print(fibboIteration(0))
  print(fibboIteration(1))
  print(fibboIteration(2))
  print(fibboIteration(3))
  print(fibboIteration(4))
  print(fibboIteration(5))
  println(fibboIteration(6))

//task 2
  println("task 2")
  println(divide(3,2))
  println(divide(4,0))

  //task 3 below
}

/*
1.Write a method which return n-th Fibonacci number in
  a.Functional way (using recurrence)
  b.imperative way (using loop)
2.Write your own exception which will be thrown by method div when division by zero occurs.


3.What is printed and why by Java code: true, false.
  In first case we are comparing a primitive data type, so this function returns true
  In second case we are comparing objects (instantiates),
  they are located in different places in memory,
  so in fact this is not a comparison of values,
  but hash codes. As a result we get false. (To get true we should use function equals())
4. String is an object which is built by characters, so at first results could be a bit unintuitive.
  (true, true, false, true)
  But Java does its magic, or simply interns two first strings (s1,s2) to the same object,
  as both of them have the same value "foo". In the third string (s3) Java takes it more serious,
  as we show it that we want to instantiate new object, so it has different hash code than two previous
  strings, so with "s1 == s3" we get false, but using "s1.equals(s3)" we get true (it checks attributes of objects,
  not its hashcode.

*/
