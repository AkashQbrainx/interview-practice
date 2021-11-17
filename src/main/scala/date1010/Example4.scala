package date1010

import scala.annotation.tailrec

object Example4 extends App {

  def sum1(input:List[Int]):Int={
    @tailrec
    def sum(input:List[Int], out:Int):Int={
      input match {
        case Nil=>out
        case head::tail=>sum(tail,out+head)
      }
    }
    sum(input:List[Int],0)
  }
  println(sum1(List(-1,2,3,4,-5)))

}
