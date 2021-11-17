package date1611

import scala.annotation.tailrec

object Map extends App{

  def map[A,B](input:List[A])(fx:A=>B):List[B]={

    @tailrec
    def map1(input:List[A], output:List[B])(fx:A=>B):List[B]={
    input match {
      case Nil=>output
      case head::tail=>map1(tail,output.appended(fx(head)))(fx)
    }
    }
    map1(input,List.empty)(fx)
  }
  println(map(List(1,2,3,4))(f=>f*2))

  val a=List(1,2,3,4)
  println(a.find(f=>f%2==0))
}
