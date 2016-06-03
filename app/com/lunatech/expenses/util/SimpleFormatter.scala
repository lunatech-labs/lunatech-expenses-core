package com.lunatech.expenses.util

import play.api.data.FormError
import play.api.data.format.Formatter

abstract class SimpleFormatter[T] extends Formatter[T] {

  override def bind(key: String, data: Map[String, String]) = data.get(key) match {
    case Some(str) => Right(bind(str))
    case None => Left(Seq(FormError(key, notFoundMessage)))
  }

  override def unbind(key: String, value: T) = Map(key -> value.toString)

  def bind(param: String): T

  def notFoundMessage: String = "Value is missing"

}

object SimpleFormatter {
  def format[T](doFormat: (String) => (T)) = new SimpleFormatter[T] {
    override def bind(param: String) = doFormat(param)
  }
}