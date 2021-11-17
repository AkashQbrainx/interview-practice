package Kafka

import org.apache.kafka.clients.producer.{KafkaProducer, ProducerRecord}

import java.util.Properties
import scala.io.StdIn

object ProducerApp extends App {

val properties=new Properties()
  properties.put("bootstrap.servers", "localhost:9094")
  properties.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  properties.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer")
  val producer = new KafkaProducer[String, String](properties)
  for(i <- 0 to 5)
{

    val record = new ProducerRecord[String, String]("akash", "key",s"$i")
    producer.send(record)
  }
  producer.close()
}
