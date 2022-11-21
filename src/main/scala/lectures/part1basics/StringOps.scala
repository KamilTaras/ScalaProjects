package lectures.part1basics




object StringOps  extends  App {
val str: String = "Hello, I'm learning Java"

  val name: String = "Andrzej"
val age: Int = 14
//s- interpolars
val greetings: String = s"Hello, my name is $name and I am $age years old"
val anotherGreeting: String = s"Hello, my name is $name and I am turning ${age + 1} years old"

//f-interpolars
val speed = 1432.2694201f
val myth = f"$name%s can eat $speed%2.3f burgers per minute "
  println(myth)


  //raw-interpolar
  val escaped = "This is a \n newline"
  println(raw"$escaped")
}
