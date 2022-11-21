package Labs



//task 1
def sum(list:List[Int]): Int = {

  def isANumberOdd (n: Int): Boolean = {
    if (n % 2 !=0) true
    else false
  }

  def helpMe (sum: Int, list: List[Int]):Int = {
    if (list.isEmpty) sum
    else if (isANumberOdd(list.head)) helpMe(list.head + sum, list.tail)
    else  helpMe(sum ,list.tail)
  }

helpMe(0, list)
}

//task 2

def connectStrings (listOfString:List[String], separator:String): String = {
  val n: Int= listOfString.length
  def helpMeThereToo(listOfString:List[String], accumulator: String, n: Int, separator: String):String = {
    if (n<=0) accumulator
    else if (n == 1) helpMeThereToo(listOfString.tail ,accumulator + listOfString.head, n - 1, separator)
    else helpMeThereToo(listOfString.tail ,accumulator + listOfString.head + separator, n - 1, separator)
  }
  helpMeThereToo(listOfString,"",n, separator)
}

//task 3

def occurrence (list: List[Int], numToCheck:Int): Int = {
  def helpThere (list: List[Int], numToCheck:Int, counter:Int):Int = {
    if (list.isEmpty) counter
    else if (list.head == numToCheck) helpThere(list.tail, numToCheck, counter+1)
    else helpThere(list.tail, numToCheck,counter)
  }
  helpThere(list,numToCheck, 0 )
}

//task 4

def fibonacciFunction (n: Int):BigInt = {

  def helpThere (n: Int, previousValue:BigInt, previousPreviousValue: BigInt): BigInt = {
//    val x = previousValue + previousPreviousValue
    if (n <= 0) 0
    else if (n<=1) previousValue + previousPreviousValue
    else helpThere(n-1, previousValue + previousPreviousValue, previousValue)
  }
  helpThere(n-1, 1,0)
}

//def check (list:List[Int]): Boolean = {
////  def help (list: List[Int], previous: Int): Int ={
////    if (previous < list.head) help(list.tail, list.head)
////    else
////  }
////  help()
//}

object Lab2 extends App {

  val num: List[Int] = List(1,2,3,4,5,6,7,7,8,9)
  val num2: List[Int] = List()
  val diabolicOne: List[Int] = List(666)


  val list: List[String] = List("Uno", "Dos", "Tres")
//task 1
println("Task 1")
  println(sum(num) )
  println(sum(num2))
  println(sum(diabolicOne))

  println("Task 2")
  println(connectStrings(list,"&"))

  println("Task 3")
  println(occurrence(num, 7))
  println(occurrence(num, 1))
  println(occurrence(num, 0))

  val x:Int = 4
println("Task 4")
  println(fibonacciFunctionx(0))
  println(fibonacciFunctionx(1))
  println(fibonacciFunctionx(2))
  println(fibonacciFunctionx(3))
  println(fibonacciFunctionx(4))
  println(fibonacciFunctionx(5))
  println(fibonacciFunctionx(6))
  println(fibonacciFunctionx(7))


}


