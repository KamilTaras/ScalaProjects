package lectures.part3Functional

object AnonymousFunctions extends App{
  val doubler = new Function1[Int, Int] {
    override def apply(x: Int) = x * 2
  }

  //anonymous function (LAMBDA)
  val sugarDoubler: Int => Int = x => x * 2

  //multiple params in a lambda

  val adder: (Int, Int) => Int = (a: Int, b: Int) => a + b

  //no params
  val justDoSth: () => Int = () => 3


  //CAREFUL
  println(justDoSth) //functions itself
  println(justDoSth()) //call


  //curly braces with lambdas
  val stringToInt = { (str: String) =>
    str.toInt
  }

  //MOAR syntactic sugar
  val niceIncrementer: Int => Int = _ + 1 //equivalent to x => x + 1
  val niceAdder: (Int, Int) => Int = _ + _

  /*

  TASKS:

  Expand MyList
  -foreach method A => Unit
  [1,2,3].foreach (x=> println(x))

  -sort function ((A,A) => Int) => MyList
    [1,2,3].sort((x,y) => y-x) => [3,2,1]

  -zipWith (list, (A,A)
    [1,2,3].zipWith([4,5,6], x*y ) => [1*4, 2*5, 3*6] = [4,10,18]

  -fold(start)(function) => a value
    [1,2,3].fold(0)(x+y) = y


2. Define a method, curried & uncurried version)

  toCurry(f: (Int, Int) => Int)  => (Int => Int => Int)
  fromCurry(f:(Int => Int => Int)) => (Int, Int) => Int

3. compose (f,g) => x => f(g(x))
   andThen(f,g) => x => g(f(x))

    */
}
