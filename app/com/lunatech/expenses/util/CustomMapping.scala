package com.lunatech.expenses.util

import play.api.data.validation.Constraint
import play.api.data.{FormError, Mapping, WrappedMapping}

abstract class CustomMapping[T] extends Mapping[T] {

  override val mappings = Seq(this)
  override val constraints = Seq()

  override def bind(data: Map[String, String]) = bind(data.get(key))

  def bind(param: Option[String]): Either[Seq[FormError], T]

  override def unbind (value: T) = Map (key -> value.toString)

  override def unbindAndValidate (value: T) = unbind (value) -> Seq ()

  override def verifying (constraints: Constraint[T] *) = WrappedMapping[T, T] (this, identity, identity, constraints)

  override def withPrefix (prefix: String) = this

  }
