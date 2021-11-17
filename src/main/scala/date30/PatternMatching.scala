package date30

object PatternMatching extends App {
  trait A
  case object Section extends A
  case object Section1 extends A
  case class Student(age:Int,name:String,sec:A)
  val a= Student(12,"aakash",Section)
  a match {
    case Student(_, _,Section)=>println(a)
    case _=>println("doent match")
  }

  trait Example
 case class ExampleA(name:String,age:Int) extends Example
 class ExampleB(val name:String,val age:Int) extends Example
 object ExampleB{
   def unapply(example:ExampleB): Option[(String, Int)] =Option(example.name,example.age)
 }
  def say(ex:Example): Unit ={
    ex match {
      case x@ExampleA(name,age)=>
        println(name)
        println(age)
        println(x)
      case x@ExampleB(name,age)=>println(age)
      println(name)
      println(x)

    }
  }
  say(ExampleA("akshay",14))
  say(new ExampleB("sai",16))
}
