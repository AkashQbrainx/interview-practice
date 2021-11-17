package date0910

object FunctionCurryingExample extends App{

  def add(a:Int)=(b:Int)=>a+b
  def add1(a:Int)(b:Int)=a+b

  val a: Int => Int =add1(2)
  println(a(2))
}
