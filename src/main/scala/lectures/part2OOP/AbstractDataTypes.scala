package lectures.part2OOP

object AbstractDataTypes extends App {

  //abstract classes CAN have either ABSTRACT member or NON-ABSTRACT member
  abstract class Animal {
    val creatureType: String = "wild"
    def eat: Unit
  }

class Dog extends Animal{
  override val creatureType: String = "Canine"
  override def eat: Unit = println("crunchhh")

}


//traits CAN have either ABSTRACT member or NON-ABSTRACT member
  sealed trait Carnivore {
  def eat (animal: Animal): Unit
  val preferredMeal:String = "fresh meat"
}

  trait ColdBlooded

class Crocodile extends Animal with Carnivore() with ColdBlooded {
  override val creatureType: String = "Croc"
  override def eat: Unit = println("nomnomnom")
  def eat(animal: Animal): Unit = println(s"I am a croc and I'm eating ${animal.creatureType}")
}

val dog = new Dog
val croc= new Crocodile

  croc.eat(dog)
  croc.eat

  //differences between traits & abstract classes
  // 1 - (before Scala 3 it was impossible to write a parameter in traits)
  // 2 - multiple traits may be inherited by the same class (abs. class can be only once)
  // 3 traits = behavior, abstract = 'thing'

}
