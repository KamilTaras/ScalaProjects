package Labs

import Labs.Bool.FALSE
import Labs.Lab4.list

//1

def findPrimes (toN: Int):List[Int] = {
  def findPrimes(sieve: List[Int]): List[Int] = sieve match {
    case head :: tail => head :: findPrimes(tail.filter(x => x % head != 0))
    case Nil => Nil
  }

  findPrimes(List.range(2, toN))
}
def returnPrimes(list:List[Int]):List[Int] = list.intersect(findPrimes(200))
//2.
sealed trait TraitExpression
case class Addition(a: Int, b:Int) extends TraitExpression
case class Negation(n: Int) extends TraitExpression

def eval(expr: TraitExpression): Int = expr match {
    case Negation(n) => -n
    case Addition(a, b) => a + b
  }
//3
enum EnumExpression(a: Int, b: Int = 0):
  case Add(a: Int,b:Int) extends EnumExpression(a, b)
  case Negation(a: Int) extends EnumExpression(a)



def calcWithEnum(enumExpression: EnumExpression): Int = enumExpression match {
  case EnumExpression.Add(a: Int, b: Int) => a + b
  case EnumExpression.Negation(a: Int) => -a
}

//4
enum Bool:
  case TRUE, FALSE

def AND(a: Bool, b: Bool): Bool = (a,b) match
  case (Bool.TRUE, Bool.TRUE) => Bool.TRUE
  case _ => Bool.FALSE


def OR(a: Bool, b: Bool): Bool = (a,b) match
  case (Bool.FALSE,Bool.FALSE) => Bool.FALSE
  case _ => Bool.TRUE


def XOR(a: Bool, b: Bool): Bool = (a,b) match
  case (x,y) if x==y => Bool.FALSE
  case _ => Bool.TRUE


def NAND(a: Bool, b: Bool): Bool = AND(a, b) match
    case Bool.TRUE => Bool.FALSE
    case Bool.FALSE => Bool.TRUE

def NOR(a: Bool, b: Bool): Bool = OR(a, b) match
  case Bool.TRUE => Bool.FALSE
  case Bool.FALSE => Bool.TRUE

  def check(a: Any): String = a match {
    case a: Int => "Int"
    case a: String => "String"
    case a: Boolean => "Boolean"
    case a: Unit => "Unit"
    case a: Double => "Double"
    case _ => "What did you bring upon this cursed land"
  }

object Lab4 extends App {

  val primes: List[Int] = findPrimes(200)

  val list: List[Int] = List(2, 3, 6, 8, 199, 200)
  //2
  println("\n1 task \n")

  println(returnPrimes(list))

  println("\n2 task \n")

  println(eval(Addition(5, 5)))
  println(eval(Negation(3)))

  //3
  println("\n3 task \n")

  println(calcWithEnum(EnumExpression.Add(4, 5)))
  println(calcWithEnum(EnumExpression.Negation(4)))


  //4
  println("\n4 task \n")
  println("\nUNO \n")
  println(AND(Bool.TRUE, Bool.FALSE))
  println(AND(Bool.FALSE, Bool.FALSE))
  println(AND(Bool.TRUE, Bool.TRUE))

  println("\nDOS \n")
  println(OR(Bool.TRUE, Bool.FALSE))
  println(XOR(Bool.FALSE, Bool.FALSE))
  println(NAND(Bool.TRUE, Bool.TRUE))
  println("\nTRES \n")
  println(NAND(Bool.TRUE, Bool.FALSE))
  println(OR(Bool.FALSE, Bool.FALSE))
  println(XOR(Bool.TRUE, Bool.TRUE))
  println("\n QUARTO  \n")
  println(NOR(Bool.TRUE, Bool.FALSE))
  println(NOR(Bool.FALSE, Bool.FALSE))
  println(NOR(Bool.TRUE, Bool.TRUE))

  //5
  println("You have achieved task nr. 5")

  println(check("Howdy"))
  println(check(4))
  println(check(true))
  println(check(4.6))
  println(check(List[Int]()))
  println(Int.toString())

  //sorry for dirty code
  println("1")
}

/*
1. (2pt.) Write a function which return all primes from list of numbers (limit values
to: 0-200). Hint: use Sieve of Eratosthenes to generate list of primes and use
filter for the list.
2. (2pt.) Using ADT and pattern matching, write a simple calculator that supports
two functions: add (a + b) and negation (-n). Please use sealed trait
3. (2pt.) Using ADT and pattern matching, write a simple calculator that supports
two functions: add (a + b) and negation (-n). Please use enum (Scala 3 is needed)
4. (2pt.) Using ADT define your own Bool type and write functions AND, OR, XOR,
NAND, NOR.
5. (2pt.) Using pattern matching write function which print information what is the
type of argument. It should support 5 types.
 String, Int, Bool, Unit, Nothing


*/