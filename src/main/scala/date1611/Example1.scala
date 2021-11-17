package date1611

import scala.annotation.tailrec


object Example1 extends App {


  def sum1(input:List[Int]):Int= {

    def com1(input: List[Int], count: Int, maxVal: Int):Int = {

      input match {
        case Nil => maxVal
        case _ :: _ =>
          if(input.head==1)  com1(input.tail,count=count+1,Math.max(count+1,maxVal))
          else  com1(input.tail,0,Math.max(count,maxVal))
      }
    }
    com1(input, 0, 0)
  }
def sum(input:List[Int]):Int= {

  @tailrec
  def com(input: List[Int], index: Int, count: Int, maxVal: Int): Int = {

    if(index==input.length) maxVal
    else if(input(index)==1) com(input,index+1,count=count+1,Math.max(count+1,maxVal))
    else com(input,index+1,0,Math.max(count,maxVal))

  }

  com(input, 0, 0, 0)
}

  println(sum(List(1,1,1,1,1,0,1,1,1,1,1,1)))





}