package com.lunatech.expenses.core

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

}