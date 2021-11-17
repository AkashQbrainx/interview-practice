package date0910

object PartialFunctionExample extends App {

  val partialFunction: PartialFunction[Int, Int] =new PartialFunction[Int,Int] {
    override def isDefinedAt(x: Int): Boolean = x!=0
    override def apply(v1: Int): Int = 20/v1
  }
  println(partialFunction(2))


  val a:PartialFunction[Int,Int]={

    case x if(x!=0)=>20/x
  }
  println(a(2))

  val r:PartialFunction[Int,Int]={

    case x if(x%2==0)=>10/x
  }
val c =a orElse r
  println(c(2))

}
