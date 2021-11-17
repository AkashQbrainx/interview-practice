package day1

import scala.annotation.tailrec
import scala.util.control.Breaks.{break, breakable}

object Pallindrome extends App {

  def pal(num:Int)={

    @tailrec
    def com(num:Int, org:Int, pal:Int):Boolean={
      if(num==0) {
        if (org == pal) true
        else false
      }
        else{
          com(num/10,org,(pal*10)+(num%10))
        }
      }
    com(num,num,0)
  }
println(pal(333))

  @tailrec
  def sum(num:Int, out:Int):Int={

    if(num==0) out
    else
      {
        sum(num/10,out+ num%10)
      }
  }
  println(sum(12345,0))

//  def com(num:Array[Int]): Int ={
//
//    def com1(num:Array[Int], index:Int, count:Int):Int={
//      if(index>num.length) count
//      else
//        {
//          for(i <- index to num.length){
//
//            for(j <-index+ 1 to num.length){
//
//              if(num(i)==num(j))  return count
//              else return count+1
//            }
//          }
//          com1(num,index+1,count)
//        }
//
//    }
//    com1(num,0,0)
//  }
//  println(com(Array(1,2)))

 +1
  def com2(input:Array[Int]):Int={
    @tailrec
    def com(input:Array[Int], i:Int, j:Int, count:Int):Int={
      if(i>input.length) count
      else
        {
          if(input(i)!=input(j)) com(input,i,j+1,count)
          else com(input,i+1,1,count)
        }
    }
    com(input,0,0,0)


  }

}
