package Kafka

import org.apache.kafka.clients.consumer.KafkaConsumer
import java.util
import java.util.Properties
import scala.jdk.CollectionConverters.IterableHasAsScala

object COnsumeerApp extends App {
  val props = new Properties()
  props.put("bootstrap.servers", "localhost:9094")
  props.put("key.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("value.deserializer", "org.apache.kafka.common.serialization.StringDeserializer")
  props.put("auto.offset.reset", "latest")
  props.put("group.id", "consumer-group")
  val consumer: KafkaConsumer[String, String] = new KafkaConsumer[String, String](props)
  consumer.subscribe(util.Arrays.asList("akash"))
  while (true) {
    val records=consumer.poll(100)
    for (record<-records.asScala){
      println(record.value)
    }
  }

}
