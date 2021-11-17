package date1611

import date0910.FoldExample.foldLeft

import scala.annotation.tailrec

object FoldLeft1 extends App {

@tailrec
def foldLeft[B,A](out:B, input:List[A])(fx:(B,A)=>B):B= {
  input match {
    case Nil => out
    case head :: tail => foldLeft(fx(out, head), tail)(fx)
  }
}
  println(foldLeft(0,List(1,2,4))(_+_))
  println(foldLeft("aakash",List("akshay","arun"))(_+_))

  def foldRight[A,B](input:List[A],out:B)(fx:(A,B)=>B):B={
    input match {
      case Nil=>out
      case head::tail=>fx(head,foldRight(tail,out)(fx))
    }
  }
  println(foldRight(List("akshay","arun"),"aakash")(_+_))
}
