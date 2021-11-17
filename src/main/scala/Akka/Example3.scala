package Akka

import akka.actor.SupervisorStrategy.Decider
import akka.actor.{Actor, ActorLogging, ActorSystem, Kill, OneForOneStrategy, PoisonPill, Props, SupervisorStrategy}

import scala.concurrent.duration.DurationInt
import scala.language.postfixOps

object Example3 extends App{

  class ActorExam extends Actor with ActorLogging{

    override def receive: Receive = {
      case msg=> println(msg)
  }

    override def postStop(): Unit = {
      println("stopped")
    }
  }

  val system=ActorSystem("myActor")
  val actor=system.actorOf(Props[ActorExam],"actor")
  actor!"one"
  actor!"two"
  actor!Kill
  actor!"three"

}
