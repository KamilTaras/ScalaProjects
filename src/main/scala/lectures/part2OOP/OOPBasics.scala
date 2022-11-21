package lectures.part2OOP

object OOPBasics extends App {
  val person = new Person("John", 26)
  person.greeting("Michael")
}

class Person (name: String, age:Int) {
  val x = 2

  println(4)


  def greeting(name: String):Unit = println(s"${this.name} says: Hi, $name ")
}// age is a class parameter, but not a class member

//class parameters are NOT FIELDS, we have to add val/var to parameter

class Writer (firstName: String,surname:String,val yearOfBirth:Int){
  def fullname():Unit = println(this.firstName + " " + this.surname)
}

class Novel (name:String,yearOfRelase:Int, authorsName:String){
  def authorAge(writer: Writer):Unit =  println(writer.yearOfBirth)
  def isWrittenBy():Unit = println(this.authorsName)

  def copy(newYearOfRelease:Int):Novel = new Novel(this.name, newYearOfRelease, this.authorsName)

}