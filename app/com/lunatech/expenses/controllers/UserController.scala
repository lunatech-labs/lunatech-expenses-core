package com.lunatech.expenses.controllers

import com.lunatech.expenses.models.User
import com.lunatech.expenses.services.Repository
import play.api.data.Mapping
import play.api.data.Forms._

class UserController extends CrudController[User] {
  override def repository: Repository[User] = Repository.user;

  override protected def formMapping: Mapping[User] = mapping(
    "name" -> text,
    "email" -> text
  ) (marshall) (unmarshall)

  def marshall(name: String, email : String) = User(None, name, email)
  def unmarshall(user: User) : Option[(String, String)] =  Some(user.name, user.email)

}
