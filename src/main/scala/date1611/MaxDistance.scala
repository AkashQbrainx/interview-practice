package date1611

import scala.annotation.tailrec

object MaxDistance extends App {


  def com(input: Array[Int]): Int = {
    @tailrec
    def com1(input:Array[Int], i:Int, j:Int, count:Int, maxVal:Int):Int={

    if(i==input.length) maxVal
    else{
      if(j<input.length){
      val temp = input(i)
      if(input(j)!=temp) com1(input,i,j+1,count+1,Math.max(count,maxVal))
      else com1(input,i,j+1,count,Math.max(count,maxVal))
    }
      else
        com1(input,i+1,i+2,0,maxVal)
    }}

    com1(input,0,1,0,0)
  }
    println(com(Array(0,1,2,3,4,1)))


}
