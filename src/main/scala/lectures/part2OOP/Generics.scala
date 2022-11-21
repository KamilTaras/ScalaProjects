package lectures.part2OOP

import scala.runtime.Nothing$

object Generics extends App {
  class MyList[+A]{
    def add[B >:A](element: B): MyList[B] = ???
    /*
    A = Cat
    B = Animal
    */

  }
  class MyMap [Key, Value]

  val listOfInts = new MyList[Int]
  val listOfStrs = new MyList[String]

//  object MyList {
//    def empty[A]: MyList[A]
//  }
//  val emptyListOfIntegers = MyList.empty[Int]

  //variance problem

  class Animal
  class Cat extends Animal
  class Dog extends Animal


  //QUESTION - Does a list of Cats extends a List of Animals?


  //YES  - List[Cat] extends List[Animal] = COVARIANCE

  class CovariantList[+A]
  val  animal: Animal = new Cat
  val animalList:CovariantList[Animal] = new CovariantList[Cat]

  //  animalList.add(new Dog) ??? HARD QUESTION => we return a list of Animals instead of Cats

  //  NO - INVARIANCE
  class InvarientList[A]
  val invariantAnimalList: InvarientList[Animal] = new InvarientList[Animal]

  // 3. Hell, no! Contravariance
  class ContravariantList[-A]
  val covariantList:ContravariantList[Cat] = new ContravariantList[Animal]


  class Trainer[-A]
  val trainer: Trainer[Cat] = new Trainer[Animal]

  //bounded types

  class Cage[A <: Animal](animal: A) // <: means A is subtype of Animal
  val cage = new Cage(new Dog)

//  val newCage = new Cage(new Car)


  //expand MyList to be generic


}
