package date1010

import java.awt.geom.Line2D
import scala.annotation.tailrec

object Example2 extends App {


//  def sum(input:List[Int]):Int={
//    @tailrec
//    def com(index:Int, count:Int, max:Int): Int = {
//
//      if (index > input.length) {
//        max
//      }
//      else if (input(index) == 0) {
//        count match {
//          case _ if count > max => com(index + 1, count = 0, count)
//          case _ => com(index + 1, count = 0, max)
//        }
//      }
//      else {
//        com(index + 1, count = count + 1, max)
//      }
//    }
//    com(0,0,0)
//  }

  println(sum(List(1,1,1,0,0,1,1,1,1)))

  var max=0
  var count=0
  def sum(input:List[Int]):Int={
    @tailrec
    def com(  input:List[Int]): Int= {
      input match {
      case Nil=>max
      case head::tail=>
        head match {
          case 1=>com(tail)
          case 0=>
            if(count>max) {
              max=count
              count=0
              com(tail)
            } else {

              com(tail)
            }
        }
    }}
    com(input:List[Int])
    }
}
