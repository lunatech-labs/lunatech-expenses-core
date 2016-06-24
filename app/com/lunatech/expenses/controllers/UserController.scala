package com.lunatech.expenses.controllers

import com.lunatech.expenses.models.User
import play.api.libs.functional.syntax._
import play.api.libs.json._

class UserController {

}

object UserController {

  implicit val writesUser: Writes[User] = (
      (JsPath \ "name").write[String] and
      (JsPath \ "bankAccount").write[String] and
      (JsPath \ "email").write[String]
    ) (unlift(User.unapply))

}
