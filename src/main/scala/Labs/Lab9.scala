package Labs


trait Map[K, V] {
  def put(key: K, value: V): Unit
  def get(key: K): Option[V]
  def remove(key: K): Unit
  def contains(key: K): Boolean
  def size: Int
}

trait Set[A] {
  def add(element: A): Unit
  def contains(element: A): Boolean
  def remove(element: A): Unit
  def size: Int
}

import scala.collection.mutable.ListBuffer

class Mapa[K, V] extends Map[K,V]{
  case class Entry(key: K, var value: V)

   private val entries = ListBuffer.empty[Entry]

  def put(key: K, value: V): Unit = {
    entries.find(_.key == key) match {
      case Some(entry: Entry) => entry.value = value
      case None => entries += Entry(key, value)
    }
  }

  def get(key: K): Option[V] = entries.find(_.key == key).map(_.value)

  def remove(key: K): Unit = entries.find(_.key == key).foreach(entries -= _)

  def contains(key: K): Boolean = entries.exists(_.key == key)

  def size: Int = entries.size
}
import scala.collection.mutable.ListBuffer

class Seta[A] extends Set [A]{
  private val elements = ListBuffer.empty[A]

  def add(element: A): Unit = if (!contains(element)) elements += element

  def contains(element: A): Boolean = elements.contains(element)

  def remove(element: A): Unit = elements.find(_ == element).foreach(elements -= _)

  def size: Int = elements.size
}

object Lab9 extends App{
  val map = new Mapa[Int, String]
  map.put(1, "one")
  map.put(2, "two")
  map.put(3, "three")
  println(map.get(1)) // Some("one")
  println(map.get(2)) // SSome("two")
  println(map.get(3)) //  Some("three")
  println(map.get(4)) // None
  map.remove(2)
  println(map.get(2)) //  None
  println(map.size) //  2

  val set = new Seta[Int]
  set.add(1)
  set.add(2)
  set.add(3)
  println(set.contains(1)) //  true
  println(set.contains(2)) // true
  println(set.contains(3)) //  true
  println(set.contains(4)) //  false
  set.remove(2)
  println(set.contains(2)) //  false
  println(set.size) //  2
}
/*

ArrayList is a dynamic array,which means that we can easily add and remove elements from this structure.
From our perspective it looks like it is the same array, so we can easier operate it than in primitive list
in Java. In fact ArrayList is based on primitive list (which has fixed size), so when we add new element to
ArrayList, Java creates new primitive list with with larger size (not necessarily previousSize + 1) and add this
element to list. It is better for accessing and storing data, but less efficient when we have to add or remove
new element.

LinkedList uses a doubly linked list to store the elements. This structure is based on nodes, so we don't 
have to rewrite whole list to remove or add whole list. We only have to change information for "neighbor" nodes.
This structure is better for adding and removing elements, but is worse for accessing to elements in the middle of the list


 */