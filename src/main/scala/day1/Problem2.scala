package day1

import scala.annotation.tailrec

object Problem2 extends App {


   def find(in:String):Int= {
     @tailrec
     def add(index: Int, in:String, count: Int): Int = {
       if (index+2== in.length) count
       else if(in.charAt(index)==in.charAt(index+2))
         add(index+1,in,count+1)
       else
         add(index=index+1,in, count)
     }
     add(0,in,0)
   }
println(find("aaababab"))
}