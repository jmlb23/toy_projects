package com.github.jmlb23

import cats.effect.IO
import monix.execution.Scheduler
import monix.reactive._

import scala.io.Source
import cats.implicits._

object Hello {

  implicit val global = Scheduler.global


  def putStrLn(str: String) = IO {
    println(str)
  }

  def getLine() = IO {
    Console.in.readLine
  }

  def main(args: Array[String]): Unit = mainS(args).unsafeRunSync()


  def mainS(args: Array[String]): IO[Unit] =
    putStrLn("Introduce o nome do arquivo a analizar:")
      .flatMap(_ => getLine())
      .flatMap(x => result(x))

  def result(str: String) = Observable
    .fromIterator(Source.fromFile(str)
    .getLines())
    .flatMap(x => Observable.fromIterable(x.split("")))
    .filter(x => "aeiou".contains(x))
    .countF.foreachL(x => putStrLn(x.show).unsafeRunSync()).toIO
}

