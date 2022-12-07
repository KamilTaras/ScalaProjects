package Labs.Lab8

class Time(var timey:Int = 0){
if (timey < 0 ) this.timey = 0

  def setTime(time:Int): Unit = {
    if (time < 0) this.timey = 0
    else this.timey = time
  }

  def getTime():Int = {
    this.timey
  }

  }
//here is companion (and singleton btw)
object Time{
  def whenPaulIIdied(): String = "At 21:37"
}

object Main3 extends App{
  println(Time.whenPaulIIdied())
  val time = new Time (4)
  println(time.getTime())
  val time2 = new Time (-2)
  println(time2.getTime())
  time.setTime(-5)
  println(time.getTime())
}

