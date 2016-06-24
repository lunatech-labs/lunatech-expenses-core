package com.lunatech.expenses.controllers

import com.lunatech.expenses.models.User
import play.api.libs.json._

class UserController {

}

object UserController {

  implicit val writesUser: Writes[User] = Json.writes[User]

}
