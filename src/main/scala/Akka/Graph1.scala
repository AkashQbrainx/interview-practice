package Akka

import akka.NotUsed
import akka.actor.ActorSystem
import akka.dispatch.ExecutionContexts
import akka.stream.ClosedShape
import akka.stream.scaladsl.RunnableGraph
import akka.stream.scaladsl.{Broadcast, Flow, GraphDSL, Sink, Source, ZipWith}

import scala.concurrent.ExecutionContextExecutor

object Graph1 extends App {
  implicit val system: ActorSystem =ActorSystem("guardian")

  implicit val executionExecution: ExecutionContextExecutor =ExecutionContexts.global()
  val graph=GraphDSL.create(){

    implicit  builder:GraphDSL.Builder[NotUsed]=>import GraphDSL.Implicits._

      val source=Source(1 to 5)

      val flow0=Flow[Int].map(_+2)
      val flow1=Flow[Int].map(_+3)

      val broadcast=builder.add(Broadcast[Int](2))
      val zip=builder.add(ZipWith[Int,Int,String]((a,b)=>s"first $a,second$b"))

      val sink=Sink.foreach[String](f=>println(s"$f"))
      source ~>broadcast
      broadcast.out(0) ~> flow0 ~> zip.in0
      broadcast.out(1) ~> flow1 ~> zip.in1
      zip.out ~> sink

      ClosedShape
  }
  val run=RunnableGraph.fromGraph(graph).run()
}
