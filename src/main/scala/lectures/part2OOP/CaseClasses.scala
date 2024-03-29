package lectures.part2OOP

object CaseClasses extends App {

  /*
    equals, hashCode, toString
  */

  case class Person (name: String, age:Int)

  //1. class parameters are fields
  val jim = new Person("Jim", 34)
  println(jim.name)

  //2. sensible toString
  //  println(instance) = println(instance.toStrong) // syntactic sugar
  println(jim)

//  3. equals and hashCode implemented OOTB

  val jim2 = new Person("Jim", 34)
  println(jim == jim2)

  // 4. Case Classes have hand copy methods

  val jim3 = jim.copy(age = 45);

    //5. CCs have companion objects

    val thePerson = Person
    val mary = Person("Mary", 23)

  // 6. CC are serializable

  //Akka

  //7. CCs have extractor patterns = CCs can be used in Pattern Matching

  case object UnitedKingdom{
    def name:String = "The UK of GB and NI"
  }
}


