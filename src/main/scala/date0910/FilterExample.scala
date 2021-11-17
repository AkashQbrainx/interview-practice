package date0910

object FilterExample extends App {
  def filter[A](input: List[A])(fx: A => Boolean): List[A] = {
    for (
      x <- input if fx(x)
    ) yield x
  }
  val list=List(1,2,3,4,5)
  println(filter(list)(f=>f%2==0))
  val list1=List("aakash","sai","arun","gokul")
  println(filter(list1)(f=>f.startsWith("a")))

}