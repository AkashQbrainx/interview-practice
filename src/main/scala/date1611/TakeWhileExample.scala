package date1611

object TakeWhileExample extends App {

  val a: List[Int] =List(1,2,3,4,5,6,5,3,4,2)
    println(a)
println(List(1,2,3,4,5).takeWhile(f=>f>3))

 val a1= List("aakash","arun","gokul").foldLeft("aaaaa")(_+_)
  val a2= List("aakash","arun","gokul").foldRight("aaaaa")(_+" "+" "+_)
  println(a1)
  println(a2)
}
