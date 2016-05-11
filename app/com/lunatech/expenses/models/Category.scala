package com.lunatech.expenses.core

import play.api.data.validation.Constraint
import play.api.data.{FormError, Mapping, WrappedMapping}

sealed trait Category

case object Food extends Category
case object Travel extends Category
case object Hardware extends Category
case object Software extends Category
case object Phone extends Category

object Category {
  val formMapping: Mapping[Category] = new Mapping[Category] { self =>

    override val key: String = "category"
    override val mappings: Seq[Mapping[_]] = Seq(this)
    override val constraints: Seq[Constraint[Category]] = Seq()

    override def bind(data: Map[String, String]): Either[Seq[FormError], Category] =
      data.get(key) match {
        case Some("Travel") => Right(Travel)
        case Some("Food") => Right(Food)
        case Some("Hardware") => Right(Hardware)
        case Some("Software") => Right(Software)
        case Some("Phone") => Right(Phone)
        case Some(str) => Left(Seq(FormError(key, s"'$str' is not a Category")))
        case None => Left(Seq(FormError(key, "No Category provided")))
      }

    override def unbind(value: Category): Map[String, String] = {
      Map(key -> value.toString)
    }

    override def unbindAndValidate(value: Category): (Map[String, String], Seq[FormError]) =
      unbind(value) -> Seq()

    override def verifying(constraints: Constraint[Category]*): Mapping[Category] =
      WrappedMapping[Category, Category](this, identity, identity, constraints)

    override def withPrefix(prefix: String): Mapping[Category] = self

  }

}