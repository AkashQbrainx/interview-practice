package date1611

import scala.annotation.tailrec

object pivot1 extends App {


  def sum(input:Array[Int]): Int = {

    @tailrec
    def com(input: Array[Int], pos: Int, out: Int): Int = {
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

      if (out == pos) pos
      else if (preAdder(pos, input) == postAdder(pos, input)) com(input, pos, out = pos)
      else com(input, pos + 1, out)

    }
    com(input,1,0)
  }

println(sum(Array(1,2,1,2,1)))
}
