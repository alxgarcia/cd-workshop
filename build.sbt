name := "DummyServer"

version := "0.1"

scalaVersion := "2.12.4"

libraryDependencies ++= Seq(
  "com.typesafe.akka" %% "akka-http" % "10.0.10",
  "com.typesafe.akka" %% "akka-http-testkit" % "10.0.10" % Test,
  "org.scalatest" %% "scalatest" % "3.0.4" % Test
)

mainClass in Compile := Some("greetings.Main")