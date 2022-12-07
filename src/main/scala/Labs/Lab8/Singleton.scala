package Labs.Lab8

object Singleton {
  def whoAmI():Unit = println("Hello, I am a singleton")
}
object Main4 extends App{
  Singleton.whoAmI()
}

