package Labs.Lab8


class Author(private var name: String, private var email: String, private var gender: Char) {
  def getName: String = name

  def setName(name: String): Unit = {
    this.name = name
  }

  def getEmail: String = email

  def setEmail(email: String): Unit = {
    this.email = email
  }

  def getGender: Char = gender

  def setGender(gender: Char): Unit = {
    this.gender = gender
  }

  override def toString = s"Author($name, $email, $gender)"
}

class Book(var name: String,var author: Author,var price: Double, var qty:Int) {




  def getName: String = name

  def setName(name: String): Unit = {
    this.name = name
  }


  def getPrice: Double = price

  def setPrice(price: Double): Unit = {
    this.price = price
  }

  def getQty: Int = qty

  def setQty(qty: Int): Unit = {
    this.qty = qty
  }

  override def toString = s"Book($name, $author, $price, $qty)"
}

object Main5 extends App {
  val author1 = new Author("Marysia", "ok@gmail.com", 'f')
  val author2 = new Author("Andrzej", "git@wp.com", 'm')
  val authors = Array(author1, author2)

  val book1 = new Book("Heart Of Darkness", author1, 69.99, 2)
  val book2 = new Book("Bible", author2, 6.51, 5)


  System.out.println(book1.toString)
  System.out.println(book2.toString)
}