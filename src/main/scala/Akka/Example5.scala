package Akka

import akka.Done
import akka.actor.ActorSystem
import akka.actor.typed.scaladsl.Behaviors
import akka.dispatch.ExecutionContexts
import akka.stream.scaladsl.{Flow, Keep, RunnableGraph, Sink, Source}

import scala.concurrent.{ExecutionContextExecutor, Future}
import scala.util.{Failure, Success}


object Example5  extends App{
 implicit val system: ActorSystem =ActorSystem("guardian")

 implicit val executionExecution: ExecutionContextExecutor =ExecutionContexts.global()
//Source(1 to 5)
//  .runForeach(f=>println(s"$f"))
//  .onComplete{
//    case Success(value)=>println(value)
//    case Failure(exception)=>println(exception)
//  }

  val flow=Flow[Int].map(_*2)
  val source=Source(1 to 5)
  val sink: Sink[Int, Future[Done]] = Sink.foreach(f => println(f.toString))
 val graph: Future[Done] = source.via(flow).toMat(sink)(Keep.right).run()

}
