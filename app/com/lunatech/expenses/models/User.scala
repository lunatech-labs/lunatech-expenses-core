package com.lunatech.expenses.models

import play.api.libs.json.Json

case class User (name: String, bankAccount: String, email: String)


object User {

  implicit val writesUser = Json.writes[User]

}
