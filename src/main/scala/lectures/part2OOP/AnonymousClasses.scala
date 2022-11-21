package lectures.part2OOP

object AnonymousClasses extends App {


  abstract class Animal {
    def eat:Unit
  }
    //anonymousC



  val funnyAnimal:Animal = new Animal{
    override def eat: Unit = print("FFFFFFF")
  }

  /*
  class AnonymousClasses$$anon$1 extends Animal{
    override def eat: Unit = println("FFFFFFF")
  }
  val funnyAnimal:Animal = new AnonymousClasses$$anon$1

    */

  println(funnyAnimal.getClass)


  class Person(name:String){
    def sayHi():Unit = println(s"Hi, my name is $name, how can I help you?")
  }

  val jim = new Person("Jim"){
    override def sayHi(): Unit = println(s"Hi, my name is Jim, how can I be of service")
  }
}
