package date0910

import scala.annotation.tailrec

object FoldExample extends App{

  @tailrec
  def foldLeft[B,A]( out:B,input:List[A])(fx:(B,A)=>B):B={
    input match {
      case Nil=>out
      case head::tail=>foldLeft(fx(out,head),tail)(fx)
    }
  }
  println(foldLeft("",List(1,2,3,4))((a,b)=> {
  println(s"$a+$b")
  a + b
}))

  println(foldLeft("Hello",List("scala","java"))(_+_))

  def foldRight[A,B](z:A,input:List[B])(fx:(B,A)=>A):A={
       input match {
      case Nil=>z
      case head::tail=>fx(head,foldRight(z,tail)(fx))
    }
  }

println(List(1,2,3).foldRight("aaka")(_+_))

}
