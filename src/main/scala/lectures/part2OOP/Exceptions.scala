package lectures.part2OOP

import scala.language.postfixOps

object Exceptions  {


//  val x: String = null
//  println(x.length)
//this will crash with NPE


//1. throwing

//val aWeirdValue: String = throw new NullPointerException()

//throwable classes extend the Throwable class
//Exception and Error are the major Throwable subtypes


//  2.catching exceptions
def getInt(withExceptions:Boolean):Int =
  if (withExceptions) throw new RuntimeException("No int for you")
  else 42


val potentialFail = try {
  getInt(false)
}catch {
 case e: RuntimeException => 50
}finally {
  //does not influence to return type of this expression
  //use finally only for side effects
}


//3. how to make exception
//
//class MyException extends Exception
//val exception = new MyException
//
//  throw exception
//
//println(potentialFail)


  def main(args: Array[String]): Unit = {
var lis:List[BigInt]= List(0,1,2)
    var i: BigInt = 0

    while (true){
      i *= 2
      lis =  (i::lis)
      println(lis)

    }
  }



}


