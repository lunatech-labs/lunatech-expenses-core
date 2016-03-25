lazy val root = (project in file(".")).
  settings(
    name := "lunatech-expenses-core",
    version := "0.1-SNAPSHOT",
    scalaVersion := "2.11.8",

    libraryDependencies ++= Seq(
      "org.typelevel" %% "cats" % "0.4.0",
      "org.scalatest" %% "scalatest" % "2.2.6" % "test"
    )
  )


