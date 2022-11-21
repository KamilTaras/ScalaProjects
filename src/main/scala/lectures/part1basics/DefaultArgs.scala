package lectures.part1basics

def trFact (n: Int, acu: Int = 1) : Int = {
  if (n<= 1) acu
  else trFact(n-1,n*acu)
}

object DefaultArgs extends App {
  println(trFact(3))
  println(trFact(4))

}
