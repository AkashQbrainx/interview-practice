package Akka

import Akka.Example1.ActorExample.props
import akka.actor.{Actor, ActorLogging, ActorRef, ActorSystem, Props}

object Example1 extends App
{
  object ActorExample{
    def props(age:Int): Props =Props(new ActorExample(age))
  }
  class ActorExample(val age:Int) extends Actor with ActorLogging{
     val actor2: ActorRef =context.actorOf(Props[Actor2],"actor2")
    override def receive: Receive = {
      case msg=>log.info(s"$msg,$age")
        actor2 ! msg
    }
    override def preStart(): Unit = {    // overriding preStart method
      println("preStart method is called");
    }
  }

  class Actor2 extends Actor with ActorLogging {
    override def receive: Receive = {
      case msg=>log.info(s"$msg")
    }
  }
 val sys: ActorSystem =ActorSystem("myactor")
  val actor1: ActorRef =sys.actorOf(props(12),"actor1")
  actor1 ! "hello"
}
