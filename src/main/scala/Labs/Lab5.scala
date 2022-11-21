package Labs

// task 1
def lrepeat[A](k: Int)(lxs: LazyList[A]): LazyList[A] = lxs.flatMap(x => LazyList.fill(k)(x))

//task 2
def fibs: LazyList[Int] = 0 #:: 1 #:: fibs.zip(fibs.tail).map { n => n._1 + n._2 }

//task 3
trait lBT[+A]

case object LEmpty extends lBT[Nothing]

case class LNode[+A](elem: A, left: () => lBT[A], right: () => lBT[A]) extends lBT[A]

def makeNode(n: Int): LNode[Int] = LNode(n, ()=> makeNode(2 * n), ()=> makeNode(2 * n + 1))

object Lab5 extends App {
//TODO: zrób mi loda xdd

  val lazyList = LazyList.from(0).take(11)

  println("task 1")
  lrepeat(4)(lazyList).foreach(print)

  println("\ntask 2")
  fibs.take(15).foreach(println)

  println("task 3")

  val root: LNode[Int] = makeNode(14)
  val lNode = root.left().asInstanceOf[LNode[Int]]
  val rNode = root.right().asInstanceOf[LNode[Int]]

  println(root.elem)
  println(lNode.elem)
  println(rNode.elem)

  println(lNode.left().asInstanceOf[LNode[Int]].elem)
  println(lNode.right().asInstanceOf[LNode[Int]].elem)
  println(lNode.left().asInstanceOf[LNode[Int]].elem)
  println(lNode.right().asInstanceOf[LNode[Int]].elem)


  //  functional programming is cursed.
  //  I am afraid this amount of syntactic sugar will give me diabetes
}


//
//1. (3pt.) Define a function which for each number k (1…n) converts lazy list to lazy
//list in which each element of input list occurs k times
//  lrepeat : [A](k: Int)(lxs: LazyList[A])LazyList[A]
//  2. (3pt.) Define function which generate Fibonacci Sequence in lazy way
//fib : LazyList[Int]
//3. (4pt.) For lazy binary tree:
//trait lBT[+A]
//case object LEmpty extends lBT[Nothing]
//case class LNode[+A](elem:A, left:()=>lBT[A],
//                     right:()=>lBT[A]) extends lBT[A]
//define function which generate infinity tree which as root has number n (parameter)
//and sub trees: Tree (2*n) and Tree( 2*n+1).