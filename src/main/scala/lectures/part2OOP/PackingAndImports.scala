package lectures.part2OOP

import lectures.playground.PrinceCharming
import java.util.Date
import java.sql.{Date => SqlDate}



object PackingAndImports extends App{

  val writer = new Writer("Daniel", "Rock", 2018)


  val prince = new PrinceCharming

  val date = new Date
  val sqlDate = new SqlDate(2018,4,3)


  //default imports
  //java.lang - String, Objects, Exception
  //scala - Int, Nothing, Function
  //scala.Predef - println, ???


}
