package date30

object HigherOrderFn extends App {

  def add(a:Int,b:Int,fn:(Int,Int)=>Int):Int=fn(a,b)
  println(add(1,2,(a,b)=>a+b))


  def add1(a:Int):Int=>Int=b=>a+b
 val a1: Int => Int =add1(2)
  println(a1(3))

  def add2(a:Int)(b:Int)(c:Int): Int =a+b+c

  val a2: Int => Int => Int =add2(1)
  println(a2)


}
