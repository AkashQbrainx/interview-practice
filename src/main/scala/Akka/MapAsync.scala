package Akka

import Akka.Async.system
import akka.actor.ActorSystem
import akka.dispatch.ExecutionContexts
import akka.stream.scaladsl.Source

import scala.concurrent.{ExecutionContextExecutor, Future}

object MapAsync extends App {
  implicit val system: ActorSystem =ActorSystem("guardian")

  implicit val executionExecution: ExecutionContextExecutor =ExecutionContexts.global()
//Source.fromIterator(()=>new Iterator[Int] {
//  var n=0
//  override def hasNext: Boolean = true
//
//  override def next(): Int = {
//    n+=1
//    n
  //}
//}

  Source(1 to 5)

  .mapAsync(5)(f=>Future(f+1))
    .map(_*2)
    .map(
      f=>{
        println(s"first-$f")
      f})
    .mapAsync(2)(f=>Future(f))
    .map(_*3)
    .map(
    {
      f=>println(s"second-$f")
    f}).runForeach(f=>println(s"last-$f"))


}
