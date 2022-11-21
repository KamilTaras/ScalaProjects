package lectures.part2OOP

object Objects extends App {
  //SCALA DOESN'T HAVE CLASS-LEVEL FUNCTIONALITY ("static")


  object Person { // type + its only instance
    // "static"/"class" - level functionality
    val N_EYES = 2
    def canFly: Boolean = false

    def apply(mother:Person, father:Person) = new Person("Bobbie")
  }

 class Person (val name: String) {
  //instance- level functionality
 }

 //Companions

  println(Person.N_EYES)
  println(Person.canFly)

  //Scala object = SINGLETON INSTANCE
  val mary = new Person ("Mary")
  val john = new Person ("John")

  println(mary == john)

  val person1 = Person
  val person2 = Person

  println(person1 == person2)

  val bobbie = Person(mary,john) //Person.apply(mary,john) is an equivalent

  //Scala Applications = Scala object with
  // def main(args: Array[String]): Unit
}
