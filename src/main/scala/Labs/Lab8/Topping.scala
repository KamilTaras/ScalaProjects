package Labs.Lab8

import scala.collection.mutable.ArrayBuffer

sealed trait Topping
case object Cheese extends Topping
case object Pepperoni extends Topping
case object Sausage extends Topping
case object Mushrooms extends Topping
case object Onion extends Topping

sealed trait CrustSize
case object SmallSize  extends CrustSize
case object MediumSize extends CrustSize
case object LargeCrustSize extends CrustSize

sealed trait CrustType
case object RegularCrustType extends CrustType
case object ThinCrustType  extends CrustType
case object  ThickCrustType extends CrustType

trait ToppingsManager {
  def addTopping(t: Topping): Unit
  def removeTopping(t: Topping): Unit
  def removeAllToppings(): Unit
}
//TODO: Task 1
class Customer(var name:String,var phoneNumber:Int, var address:Address)
class Address(var street:String, var city:String)


class Pizza (var crustSize: CrustSize, var crustType: CrustType, var toppings: ArrayBuffer[Topping]) extends ToppingsManager{
  override def addTopping(t: Topping): Unit = toppings += t
  override def removeTopping(t: Topping): Unit = toppings -= t
  override def removeAllToppings(): Unit = toppings.clear()

  def countPrice(): Double = {
    val sizePrice:Double = crustSize match
      case SmallSize => 7.00
      case MediumSize => 10.00
      case LargeCrustSize => 12.00

    val typePrice:Double = crustType match
      case ThinCrustType => 5
      case RegularCrustType => 6
      case ThickCrustType => 7


    val toppingPrice = toppings.map{
      case Cheese => 4.0
      case Pepperoni => 6.0
      case Sausage => 5.0
      case Mushrooms => 3.0
      case Onion => 2.0
    }.sum


    sizePrice+typePrice+toppingPrice
  }
}

class Order(var pizzas: ArrayBuffer[Pizza], var customer: Customer)

object Main extends App {
  val  pizza = new Pizza(crustSize = LargeCrustSize, crustType = ThinCrustType , toppings = ArrayBuffer(Cheese,Sausage,Onion))
  println(pizza.countPrice())
}
