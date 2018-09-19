import sbt._

object Dependencies {
  lazy val scalaz = "org.scalaz" %% "scalaz-zio" % "0.2.7" ::
    "org.scalaz.stream" %% "scalaz-stream" % "0.8.6" ::
                    Nil
}
