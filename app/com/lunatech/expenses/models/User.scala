package com.lunatech.expenses.models

import play.api.libs.json.Json

case class User (id: Option[Int] = None, name: String, email: String) extends Entity[User] {
  override def withId(id: Int): User = this.copy(id = Some(id))
}


object User {

  implicit val writesUser = Json.writes[User]

}
