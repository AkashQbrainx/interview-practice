package date1010

object Example1 extends App {

trait A{
  def print():Unit
}

  trait D{
    def print1():Unit
  }
abstract class B{
    def sum():Unit
  }

  class C extends B with A with D{
    override def print(): Unit = println("trait A")

    override def sum(): Unit = println("trait B")

    override def print1(): Unit = println("trait D")
  }
  val c=new C
  c.print()
  c.sum()
  c.print1()

  val list=List(1,2,3,4)
  println(list.head)
}
