package Akka

import akka.actor.ActorSystem
import akka.dispatch.ExecutionContexts
import akka.stream.scaladsl.Source
import akka.stream.{Attributes, Outlet, SourceShape}
import akka.stream.stage.{GraphStage, GraphStageLogic, OutHandler}

import scala.concurrent.ExecutionContextExecutor
import scala.concurrent.duration.FiniteDuration

class CustomGraph extends GraphStage[SourceShape[Int]]{
  val outlet: Outlet[Int] = Outlet("CustomOutlet")
  override def createLogic(inheritedAttributes: Attributes): GraphStageLogic = CustomGraphLogic

  object CustomGraphLogic extends GraphStageLogic(shape)
  {
setHandler(outlet,CustomOutHandler)
    object CustomOutHandler extends OutHandler{
     var i=0
      override def onPull(): Unit = {
        println("injecting")
        push(outlet, i)
        i+=1
      }
    }
  }
  override def shape: SourceShape[Int] =SourceShape(outlet)
}
object Main extends App
{
  implicit val system: ActorSystem =ActorSystem("guardian")

  implicit val executionExecution: ExecutionContextExecutor =ExecutionContexts.global()
  val source=Source.fromGraph(new CustomGraph)
  source.throttle(2,FiniteDuration(3,"seconds"))runForeach(f=>println(s"$f"))
}