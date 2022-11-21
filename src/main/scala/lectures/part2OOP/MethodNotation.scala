package lectures.part2OOP

import jdk.jfr.Description

import scala.language.postfixOps

object MethodNotation extends App {

//person, vame, fav movie

class Person(val name:String,val favoriteMovie:String, val age:Int = 0){
  def likes (movie:String):Boolean = movie == favoriteMovie

  def + (person: Person):String = s"${this.name} is outside with ${person.name}"
  def unary_+ : Person = new Person(this.name, this.favoriteMovie, age + 1)
  def unary_! : String = s"$name, what the heck?!"

  def isAlive: Boolean = true

  def apply(): String = s"Hi, my name is $name, and my fav movie is $favoriteMovie"
  def +(nickname:String):Person = new Person(s"$name ($nickname)", this.favoriteMovie) //1st task
  def apply (times: Int) : String = if (times == 1) s"$name watched $favoriteMovie once" else s"$name watched $favoriteMovie $times times"

  def learns(thing:String) : String = s"$name learns $thing"
  def learnsScala : String = this learns "Scala"
  override def toString = s"Person($name, $favoriteMovie, $age)"
}


val mary = new Person("Mary", "Inception")
val peter = new Person("Peter", "Lemon Party")

  println(mary.likes("Inception"))
  println(mary likes "Inception")// works only with one parameter
  //infix notation = operator notation (syntactic sugar)

  println(mary + peter)
  println(peter + mary)
  println(mary.+(peter))

  //all operators are methods



  //prefix notation

  val x = -1 // equivalent with 1.unary_-
  val y = 1.unary_-

  //unary_prefix only works with + - ~(tilda) !(bang operator)

  println(!mary)
  println(mary.unary_!)

  //postfix notation
  println(mary.isAlive)
  println(mary isAlive)

  //apply

  println(mary.apply())
  println(mary())


 /*
 1. Overload the + operator:
 marry + "the rockstar" => new person "Mary ( the rockstar)"

 2. Add an age to the Person class
 Add a unary + operator => new person with the age + 1
 +mary => mary with the age incrementer

 3. Add a "learns" method in the Person class => "Mary learns Scala"
  Add a learnScala method, calls learns method with "Scala
  use postfix notation


  4. Overload the apply method
    marry.apply(2) => "Mary watched Inception 2 times"
 */

  println(mary)

  println((mary + "the rockstar")())
  println((mary + "the rockstar").apply())

  println(mary learns "Scala")
  println(mary learnsScala)

  println(mary.apply(2))
  println(mary.apply(1))
  println(mary.apply(3))

  println(+mary)
 }
