package Labs


//1.
def sumList (list: List[Int]):Int = {

  def insideFunction (list: List[Int], sum:Int):Int = {
    if (list.nonEmpty) insideFunction(list.tail,sum + list.head)
    else sum
  }
  insideFunction(list,0)
}

  //2. (1pt)	Create	a	method	reversing	a	list:
  //  a)	regular	recursion,
  //  b)	tail	recursion,

def reveseListTail (list: List[Int]):List[Int] = {

  var revesedList  = List[Int]()


    def insideFunction(list: List[Int], reversedList: List[Int]):List[Int] = {
      if (list.nonEmpty) insideFunction(list.tail, list.head :: reversedList)
      else reversedList
    }
  insideFunction(list, revesedList)
}



//3. (2pt)	Create	a	method	that	merges	two	lists	in	such	a	way	that	elements
//  of	both lists	alternate,	e.g.	for	lists	[1,	2,	3]	and	[4,	5,	6]
//result	is	[1,	4,	2,	5,	3,	6].
//If	one	of	the	lists	have	too	many	elements,	add	rest	of	them	to
//the	end	of	the result.


def mergeList (list1: List[Int], list2: List[Int]):List[Int] = {

  var list3  = List[Int]()


  def leftChoice(list1: List[Int],list2: List[Int],list3: List[Int]): List[Int] = {
    if (list1.nonEmpty) rightChoice(list1.tail, list2, list1.head :: list3)
    else if (list2.nonEmpty) rightChoice(list1, list2.tail, list2.head :: list3)
    else list3
  }

  def rightChoice (list1: List[Int],list2: List[Int],list3: List[Int]): List[Int] = {
    if (list2.nonEmpty) leftChoice(list1,list2.tail, list2.head :: list3)
    else if (list1.nonEmpty) leftChoice(list1.tail, list2, list1.head :: list3)
    else list3
  }

  rightChoice(list1,list2,list3)
}

//4. (2pt)	Write	a	function	which	return	n-th	Fibonacci	number and	use	tail
//  recursion.	Compare	the	solution	with	the	code	from	last	tutorials.

def fibonacciFunctionx(n: Int):BigInt = {

  def insideFunction (n: Int, previousValue:BigInt, previousPreviousValue: BigInt): BigInt = {
        val x = previousValue + previousPreviousValue
    if (n <= 0) 0
    else if (n<=1) x
    else insideFunction(n-1, x, previousValue)
  }
  insideFunction(n-1, 1,0)
}

//  5. (2pt)	Write	function	which	split	list	to	two	lists:
//    - first	include	only	odd	numbers
//    - second	include	only	even	numbers

def split(list: List[Int]):List[List[Int]] = {

  var oddList  = List[Int]()
  var evenList = List[Int]()

  def isANumberOdd (n: Int): Boolean = {
    if (n % 2 !=0) true
    else false
  }

  def helpFunction(list: List[Int], oddList: List[Int], evenList:List[Int]):List[List[Int]] = {
    if (list.nonEmpty && isANumberOdd(list.head)) helpFunction(list.tail, list.head :: oddList, evenList)
    else if (list.nonEmpty && !isANumberOdd(list.head))helpFunction(list.tail, oddList,list.head :: evenList)
    else List(oddList,evenList)
  }
  helpFunction(list, oddList,evenList)
}

//6. (1pt)	Write	a	function	which	check	that	numbers	in	provided	list
//are	correctly sorted.	Please	use	tail	recursion.

  def isSortedProperly(list: List[Int]):Boolean = {

    def heeeeelp(list: List[Int], previousNumber: Int):Boolean = {
      if (list.nonEmpty && previousNumber <= list.head) heeeeelp(list.tail, list.head)
      else if (list.nonEmpty && previousNumber > list.head) false
      else true
    }
    heeeeelp(list.tail,list.head)
  }

//7. (2pt)	Define	the	replace Nth	function,	which	replace	the	n-th
//element	of	the	list by	given	value. Remember	to	do	not	use	standard	library	functions	here.

def replaceNth [A](xs: List[A], n: Int, x: A):List[A] = {
  val newList  = List[A]()

  def helpFunction[A](xs: List[A], newList:List[A], numberToReach: Int, m:Int, x: A):List[A] = {
    if (m==numberToReach) helpFunction(xs.tail,x::newList,numberToReach, m+1, x)
    else if (xs.isEmpty) newList
    else helpFunction(xs.tail,xs.head::newList,numberToReach, m+1, x)

  }
  helpFunction(xs,newList,n,0,x).reverse
}

//
//(1pt)	Use	curried	representation	and	write	system	which	convert	pressure	units.
//  Input:	pressure	in	atm	(atmosphere)
//Outputs:	PSI,	bar,	torr
//1	atm =	14.6956	psi	=	760	torr	=	101325	Pa	=	1.01325	bar

def convertFromAtm(num:Float):Unit = {
  println( num + "ATM  is equal " + 14.6956*num + " PSI, or " + 1.01325*num + " bars, or "+ 760*num +"torr")
}

object Lab3 extends App {
  val list: List[Int] = List(1,2,3,4,5,6,7,7,8,9)
  val list2: List[Int] = List(11,22,33,44,55,66,77,88, 0, 0 ,0, 0, 0)
  val nonAscendingList: List[Int] = List(7,8,6,2,58,43,1)
  println(sumList(list))

  println(list.head)
  println(reveseListTail(list))
  println(mergeList(list, list2))
  println(split(list))



  println(isSortedProperly(list))
  println(isSortedProperly(nonAscendingList))


  println(replaceNth(list, 3, 69))

  convertFromAtm(1.1)
  convertFromAtm(2.3)
}


/*



7. (2pt)	Define	the	replace Nth	function,	which	replace	the	n-th
  element	of	the	list by	given	value. replaceNth: [A](xs: List[A], n: Int, x: A)List[A]
  Remember	to	do	not	use	standard	library	functions	here.


  8. (1pt)	Use	curried	representation	and	write	system	which	convert
  pressure	units.  Input:	pressure	in	atm	(atmosphere)
*/