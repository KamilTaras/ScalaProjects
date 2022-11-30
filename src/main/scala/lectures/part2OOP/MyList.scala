package lectures.part2OOP

import java.util
import util.LinkedList
import scala.annotation.targetName


abstract class MyList[+A] {

def head: A
def tail: MyList[A]
def isEmpty():Boolean
def add[B>:A](element:B):MyList[B]
def printElements: String
override def toString: String = "[" + printElements + "]"

def map[B](transformer: A=>B): MyList[B]
def flatMap[B] (transformer: A => MyList[B]):MyList[B]
def filter(predicate: A => Boolean):MyList[A]

  def ++[B >:A] (list: MyList[B]):MyList[B]
  //hofs

  def foreach(f:A => Unit): Unit
  def sort(compare: (A,A) => Int):MyList[A]


  /*
    linked list.
     head = returns first element of linked list
     tail = remainder of the list
     isEmpty =  is this list empty
     add(n: Int) => new list with this element added
     toString => a string representation of the list

  */

}


/*

1.Generic trait MyPredicate[-T] with little method test(T) => Boolean
2.Generic trait MyTransformer[-A,B] (converts value of Type A to B)
3.MyList:
  -map(transformer) => MyList
  -filter(predicate) => MyList
  -flatMap(transformer from A to MyList[B]) => MyList[B]

class EvenPredicate extends  MyPredicate[Int]
class StringToIntTransformer extends MyTransformer[String,Int]

[1,2,3].map(n*2) = [2,4,6]
[1,2,3,4].filter(n%2) = [2,4]
[1,2,3].flatMap( n, n+1]) => [1, 2, 2, 3, 3, 4]

*/

case object Empty extends MyList[Nothing] {
  def head:Nothing = throw new NoSuchElementException
  def tail: MyList[Nothing] = throw new NoSuchElementException
  def isEmpty():Boolean = true
  def add[B>:Nothing](element:B):MyList[B] = new Cons(element, Empty)
  def printElements: String = ""

  def map[B](transformer: Nothing => B): MyList[B] = Empty
  def flatMap[B](transformer: Nothing => MyList[B]): MyList[B] = Empty
  def filter(predicate: Nothing =>Boolean): MyList[Nothing] = Empty

  def ++[B >:Nothing](list: MyList[B]):MyList[B] = list

  def foreach(f:Nothing => Unit):Unit =()
  def sort(compare: (Nothing,Nothing) => Int) = Empty
}

class Cons[+A](h:A, t: MyList[A]) extends MyList[A]{
  def head:A = h
  def tail: MyList[A] = t
  def isEmpty():Boolean = false
  def add[B>:A](element:B):MyList[B] = new Cons(element, this)
  def printElements: String =
    if(t.isEmpty()) ""+ h
    else h.toString +  ", " + s"${t.printElements}"


  def map[B](transformer: A => B): MyList[B] = {
    new Cons(transformer(h), t.map(transformer))
  }

  def flatMap[B](transformer: A => MyList[B]): MyList[B] =
    transformer(h) ++ t.flatMap(transformer)

  def filter(predicate: A => Boolean): MyList[A] = {
    if(predicate(h)) new Cons(h, t.filter(predicate))
    else t.filter(predicate)
  }

  def ++[B >:A] (list: MyList[B]):MyList[B] = new Cons[B](h, t ++ list)

  //hof
  def foreach (f:A=>Unit): Unit = {
    f(h)
    t.foreach(f)
  }

  def sort(compare: (A,A) => Int):MyList[A] = {
    def insert(x: A, sortedList: MyList[A]):MyList[A] =
      if (sortedList.isEmpty()) new Cons(x, Empty)
      else if (compare(x, sortedList.head) <= 0) new Cons(x, sortedList)
      else new Cons(sortedList.head, insert(x,sortedList.tail))
    val sortedTail = t.sort(compare)
    insert(h,sortedTail)
  }

}




object ListTest extends App{
  val listOfStr: MyList[String] = new Cons("12",new Cons[String] ("fdsfgs", new Cons[String]("EEEEo", Empty)))
  val listOfInt: MyList[Int] = new Cons(1,new Cons (2, new Cons(3, Empty)))
  val anotherListOfInt: MyList[Int] = new Cons(11,new Cons (22, new Cons(33, new Cons(44, Empty))))

  listOfStr.printElements
  println(listOfStr.toString)
  println(listOfInt.toString)


  println("Transformes")
  println(listOfInt.map(_ * 2))


  println("filter")
  println(listOfInt filter (_ % 2 == 0))
  println(listOfInt.filter(_ % 2 == 0).toString)

  println("Concat")
  println((listOfInt ++ anotherListOfInt).toString)
//  println((listOfInt.++(anotherListOfInt)).toString)

  println(listOfInt.flatMap(elem => Cons(elem, Cons(elem + 1, Empty))))

  listOfInt.foreach(println)
  println(listOfInt.sort((x,y) => y - x))
}