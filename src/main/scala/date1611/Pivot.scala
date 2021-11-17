package date1611

import scala.annotation.tailrec
import scala.util.Try

object Pivot extends App {

  def com(input: Array[Int]): Int = {
    @tailrec
    def com1(input:Array[Int], pos:Int, out:Int):Int= {

      def postAdder(pos: Int, arr: Array[Int]): Int = {

        @tailrec
        def add(pos: Int, arr: Array[Int], len: Int, sum: Int): Int = {

          if (pos == len) sum
          else add(pos + 1, arr, len, sum + arr(pos))
        }

        add(pos + 1, arr, arr.length, 0)
      }

      def preAdder(pos: Int, arr: Array[Int]): Int = {

        @tailrec
        def add(pos: Int, arr: Array[Int], sum: Int): Int = {

          if (pos < 0) sum
          else add(pos - 1, arr, sum + arr(pos))
        }

        add(pos - 1, arr, 0)
      }

      if (out==pos){

        pos
      }
      else if (preAdder(pos, input) == postAdder(pos, input)) {
        com1(input, pos, out = pos)
      }
      else com1(input, pos + 1, out)
    }
    com1(input,1,0)
}
  println(com(Array(1,2,4,5,3,4)))

}
