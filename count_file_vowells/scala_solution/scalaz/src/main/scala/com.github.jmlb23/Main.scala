package com.github.jmlb23


import scalaz.zio
import scalaz.zio._



object Main extends App{

  def exit = (x:Int) => ExitStatus.ExitNow(x)

  override def run(args: List[String]): IO[Nothing, Main.ExitStatus] =
    zio.console.getStrLn.attempt.flatMap{
      case Left(x) => IO.now(exit(1))
      case Right(value) => zio.console.putStrLn(readFile(value).toString).attempt.const(exit(0))

    }

  def readFile(name: String) =
    scalaz.stream.io.linesR(name).runLog.run.toList.mkString(" ").filter(x => "aeiou".contains(x.toLower)).length

}
