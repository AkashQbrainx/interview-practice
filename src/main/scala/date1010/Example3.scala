package date1010

import scala.collection.mutable.ListBuffer

object Example3 extends App {

  var list=new ListBuffer[Int]()
  list+=1
  list+=2
  list+=3
  list--=Seq(1,2)
  println(list)

  val list1=List(1,2,6,3,4,5)
  var sum=0
  for(ele <- list1){
    sum=sum+ele
  }
  println(sum)
   var a=0
  val it: Iterator[Int] =list1.iterator
  while(it.hasNext){
    a=a+it.next()
  }
  println(a)

  var max=list1.head
  var min=list.head
  for(ele <- list1){
    if(ele<min)
      min=ele
  }
  println(min)

  val n=121
  





}
