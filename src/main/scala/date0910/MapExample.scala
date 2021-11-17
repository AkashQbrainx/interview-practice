package date0910

object MapExample extends App{

def map[A,B](input:List[A])(fx:A=>B):List[B]={
  for(
  x <- input
  )yield fx(x)
}
  val a=map(List(1,2,3,4))(f=>f*2)
  println(a)
  println(map(a)(f=>f/2))

  val string=map(a)(f=>s"i=$f")
  println(string)
}
