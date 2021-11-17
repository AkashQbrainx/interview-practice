package day1

import scala.annotation.tailrec

object Problem1 extends App {



  def sum(input:List[Int]):Int= {

    @tailrec
    def com( count: Int, input: List[Int],max:Int): Int = {
      if(input.isEmpty) max
      else if(input.head==1) com(count+1,input.tail,0)
      else {
        if(max==count)
        com(0,input.tail,max)
        else if(max>count)
          com(0,input.tail,max)

          else com(0,input.tail,count)
      }
    }

      com( 0, input:List[Int],0)

    }
  println(sum(List(1,1,0,0,1,1,1)))


}
