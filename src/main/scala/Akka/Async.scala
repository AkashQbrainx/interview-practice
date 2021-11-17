package Akka

import akka.actor.ActorSystem
import akka.dispatch.ExecutionContexts
import akka.stream.scaladsl.Source

import scala.concurrent.ExecutionContextExecutor

object Async extends App {
  implicit val system: ActorSystem =ActorSystem("guardian")

  implicit val executionExecution: ExecutionContextExecutor =ExecutionContexts.global()
  Source(1 to 5)
    .map(_*2)
    .map{f=>println(s"first map-$f")
    f}
    .async
    .map(_*3)
    .map {
      f =>
        println(s"second map-$f")
        f
    }.runForeach(f=>println(s"last-$f"))



}
