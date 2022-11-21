package lectures.part3Functional

trait MyFunction [A,B] {
  def apply (element: A): B
}

object WhatsFunction extends App {

  val doubler = new MyFunction[Int,Int] {
    override def apply(element: Int): Int = element * 2
  }
  val str1:String = "XDD"
  val str2:String = "JanPawell"
    println(conca(str1, str2))


  val strrr:String = str1 + str2
  println(strrr)


val stringToIntConverter = new ((String) => Int){
  override def apply (string:String):  Int = string.toInt
}


val adder: ((Int,Int) => Int) = new Function2[Int,Int,Int] {
  override def apply (a:Int, b:Int):Int = a+b
}

  def conca: ((String,String) => String) = (a, b) => a + b

  val conc = (a:String, b:String) => a + b

  val strangeFunction: Function1[Int, Function1[Int,Int]] = new  Function1[Int, Function1[Int,Int]]{
    override def apply(x:Int): Function1[Int, Int] = new Function1[Int, Int]{
      override def apply (y:Int): Int = x + y
    }
  }
  /*
  1. concat 2 strings to one
  2. transform MyPredicate and MyTransformer into function types
  3. define a function which takes an Int and returns another function which takes an Int & returns an Int
      -what's the type of this function
      -how to do it
  */
}




