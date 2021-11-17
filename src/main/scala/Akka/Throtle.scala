package Akka

import akka.actor.ActorSystem
import akka.dispatch.ExecutionContexts
import akka.stream.scaladsl.Source

import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration.FiniteDuration

object Throtle extends App {
  implicit val system: ActorSystem =ActorSystem("guardian")

  implicit val executionExecution: ExecutionContextExecutor =ExecutionContexts.global()
  Source(1 to 10)
    .throttle(2,FiniteDuration(5,"seconds"))
    .map(_*2)
    .runForeach(f=>println(s"$f"))
}
