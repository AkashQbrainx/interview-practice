package date1611

import scala.annotation.tailrec

object UniqueElements extends App {

  @tailrec
  def foldLeft[B,A](out:B, input:List[A])(fx:(B,A)=>B):B= {

    input match {
      case Nil => out
      case head :: tail => foldLeft(fx(out, head), tail)(fx)
    }
  }
  println( foldLeft(0,List(1,2,4,4))(_+_))
  println(foldLeft("aakash",List("akshay","arun"))((a,b)=>a+ " " +b))


  def foldRight[A,B](input:List[A],out:B)(fx:(A,B)=>B):B={


    input match {
      case Nil=>out
      case head::tail=>fx(head,foldRight(tail,out)(fx))
    }

  }
  println(foldRight(List("aakasg","akashay"),"gokul")(_+" " +_))

}