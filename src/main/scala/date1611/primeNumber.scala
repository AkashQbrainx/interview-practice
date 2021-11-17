package date1611

import scala.annotation.tailrec
import scala.util.control.Breaks.{break, breakable}

object primeNumber extends App {


  def prime(n:Int)= {


    if (n == 1) false
    else {
      for (i <- 2 to n / 2) {
        if (n % i == 0) false
        else true
      }
    }
  }
  println(prime(5))


}
