package date30

import scala.annotation.tailrec

object TailRecursion extends App{

  def fact(n:Int):Int={
    @tailrec
    def fact1(n:Int, out:Int):Int={
      if(n<=1) out
      else
        fact1(n-1,out*n)
    }
    fact1(n,1)
  }
  println(fact(10))

}
