lazy val root = (project in file(".")).enablePlugins(PlayScala)

name := "lunatech-expenses-core"
version := "0.1-SNAPSHOT"
scalaVersion := "2.11.8"

libraryDependencies += "org.scalatest" %% "scalatest" % "2.2.6" % "test"


