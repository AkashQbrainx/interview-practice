package date1611

import scala.annotation.tailrec

object FilterExample extends App{

  def filter[A](input:List[A])(fx:A=>Boolean):List[A]={

    @tailrec
    def  filter1(input:List[A], output:List[A])(fx:A=>Boolean):List[A]= {
      input match {
        case Nil => output
        case head :: tail =>
          if (fx(head)) filter1(tail, output.appended(head))(fx)
          else filter1(tail, output)(fx)
      }
    }
      filter1(input,List.empty)(fx)


  }
  println(filter(List(1,2,3,4,5,6,7))(f=>f%2==0))

}
