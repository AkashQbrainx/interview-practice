package Akka

import Akka.Example1.ActorExample.props
import Akka.Example1.sys.dispatcher
import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}
import akka.pattern.{ask, pipe}
import akka.util.Timeout

import scala.concurrent.{Await, Future}
import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object Example2 extends App {

  class Actor2 extends Actor with ActorLogging {
    override def receive: Receive = {
      case msg=>
        val a1: Future[Any] =sender() ? "received"
        log.info(s"$msg")
        a1.pipeTo(actor2)

    }
  }

  class ActorExample extends Actor{
    override def receive: Receive ={
      case msg=>println(msg)
    }
  }
  val sys: ActorSystem =ActorSystem("myactor")
  val actor1: ActorRef =sys.actorOf(Props[Actor2],"actor1")
  val actor2: ActorRef =sys.actorOf(Props[ActorExample],"actor2")
  implicit  val timeout: Timeout =Timeout(10 seconds)
val a=  actor1 ? "hello"
val fut=Await.result(a,timeout.duration)
}
