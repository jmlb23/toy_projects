import sbt._

object Dependencies {
  lazy val monix = "io.monix" %% "monix" % "3.0.0-8084549" ::
                   "org.typelevel" %% "cats-effect" % "1.0.0"::
                   Nil

}
