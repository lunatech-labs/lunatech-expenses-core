package com.lunatech.expenses.core

import com.lunatech.expenses.util.CustomMapping
import play.api.data.{FormError, Mapping}

sealed trait Category

case object Food extends Category
case object Travel extends Category
case object Hardware extends Category
case object Software extends Category
case object Phone extends Category

object Category {

  def fromString(string: String): Category = string match {
    case "Travel" => Travel
    case "Food" => Food
    case "Hardware" => Hardware
    case "Software" => Software
    case "Phone" => Phone
  }

  def mapping: Mapping[Category] = new CustomMapping[Category] {
    override val key = "category"
    override def bind(param: Option[String]) = param match {
      case Some(str) => Right(fromString(str)) //FIXME match error
      case Some(str) => Left(Seq(FormError(key, s"'$str' is not a Category")))
      case None => Left(Seq(FormError(key, "No Category provided")))
    }
  }

}