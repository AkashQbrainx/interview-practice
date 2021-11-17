name := "interview-practice"

version := "0.1"

scalaVersion := "2.13.6"
val AkkaVersion = "2.6.16"
libraryDependencies ++= Seq("com.typesafe.akka" %% "akka-actor-typed" % AkkaVersion,
  "com.typesafe.akka" %% "akka-stream" % AkkaVersion,
  "com.typesafe.akka" %% "akka-http" % "10.2.6","org.apache.kafka" % "kafka-clients" % "3.0.0"
)