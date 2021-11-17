package date30

object EqualExample extends App {
  class A(val variable: Int, val n: Int) {

    override def equals(obj: Any): Boolean = {
      if (obj == null || !obj.isInstanceOf[A]) {
        false

      } else {
        val secondObj = obj.asInstanceOf[A]
        secondObj.variable == this.variable && secondObj.n == this.n
      }
    }

  }
  val a1=new A(12,12)
  val a2=new A(12,12)
  val a3=new A(12,12)
println(a1.equals(a2))
  println(a1.eq(a2))
  println(a1==a2)
}
