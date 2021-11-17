package date1611

import scala.annotation.tailrec

object Consecutive extends App {

  def sum(input:List[Int]): Int ={

    @tailrec
    def com(input:List[Int], count:Int, maxVal:Int):Int={

      input match {
        case Nil=>maxVal
        case _ :: _ =>if(input.head==1) com(input.tail,count+1,Math.max(count+1,maxVal))
        else com(input.tail,0,Math.max(count,maxVal))
      }
    }
    com(input,0,0)
  }
  println(sum(List(1,1,0,1,1,1,1)))

}
