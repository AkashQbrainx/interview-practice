package date1611

import scala.annotation.tailrec

object FindExample extends App{
  def find[A](input:List[A])(fx:A=>Boolean):A={

@tailrec
def find1(input:List[A], out:A)(fx:A=>Boolean):A= {
  input match {
    case Nil => out
    case _ if out != null => out
    case head :: tail =>
      if (fx(head)) find1(tail, head)(fx)
      else
        find1(tail, out)(fx)
  }
}
  find1(input,null.asInstanceOf[A])(fx)
}
  println(find(List(1,2,3,4))(f=>f%2==0))

}
