package lectures.part1basics

def calledByValue (x: Long): Unit = {
  println("called by value: " + x)
  println("called by value: " + x)
}

def calledByName(x: => Long): Unit = {
  println("called by name: " + x)
  println("called by name: " + x)
}

def infinite (): Int = 1 + infinite()
def printFirst(x: Int, y: => Int) = println(x)

object CBNvsCBV extends App {
  calledByValue(System.nanoTime())
  calledByName(System.nanoTime())

//  printFirst(infinite(), 34)
  printFirst(34,infinite())


}
