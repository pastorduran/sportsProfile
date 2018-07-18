name := """sports-profile-rest"""
organization := "com.sportsprofile"

version := "1.0-SNAPSHOT"

lazy val root = (project in file(".")).enablePlugins(PlayJava)

scalaVersion := "2.12.6"

PlayKeys.externalizeResources := false

libraryDependencies += evolutions
libraryDependencies += javaJpa
libraryDependencies += guice
libraryDependencies ++= Seq(evolutions, jdbc)

libraryDependencies += "mysql" % "mysql-connector-java" % "5.1.39"
libraryDependencies += "org.hibernate" % "hibernate-core" % "5.2.17.Final"
