package date1611

import scala.annotation.tailrec

object ConsecutiveOnes extends App{

  def com(input:String):Int={

    @tailrec
    def com1(in:Array[Char], index:Int, out:Int):Int={

      if(index+2==in.length) out
      else if(in(index)==in(index+2)) com1(in, index+1,out+1)
      else com1(in,index+1,out)
    }
    com1(input.toArray,0,0)

  }
println(com("aaabab"))
}
