package Labs.Lab8

sealed trait PoopSize
case object Small extends PoopSize
case object Medium  extends PoopSize
case object Huge extends PoopSize

trait Animal {
  def makeSound():Unit
  def poopSize():PoopSize
}

class Dog extends Animal{
  override def makeSound(): Unit = println("Bark!")
  override def poopSize(): PoopSize = Medium
}

class Elephant extends Animal{
  override def makeSound(): Unit = "tooooooooooooooooooooooooooooooooooooooooooot"
  override def poopSize(): PoopSize = Huge
}


object Main2 extends App {
  val dog = new Dog
  dog.makeSound()
  println(dog.poopSize())
}