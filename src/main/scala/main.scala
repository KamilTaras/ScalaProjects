@main
def main(): Unit = {
  println("Hello world!")

  def currying(s1:String)(s2:String) = s1 + " " + s2

  println(currying("a")("b"))
  val toUncurrying = Function.uncurried(currying _)
  println(toUncurrying("a", "b"))


  def find[A](xs: List[A], predicate: A => Boolean): Option[A] = {
    xs match {
      case Nil => None
      case head :: tail => if (predicate(head)) Some(head) else find(tail, predicate)
    }
  }

  println(find(List(1, 4, 5, 7, 2, 8), x => x % 2 == 0))


}