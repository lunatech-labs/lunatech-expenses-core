package com.lunatech.expenses.controllers

import com.lunatech.expenses.models.Entity
import com.lunatech.expenses.services.Repository
import play.api.data.{Form, Mapping}
import play.api.mvc.{Action, AnyContent, Controller}

abstract class CrudController[T <: Entity[T]] extends Controller {

  val repository: Repository[T] = new Repository[T]

  def formMapping: Mapping[T]

  def create: Action[AnyContent] = Action { implicit request =>
    Form(formMapping).bindFromRequest().fold(
      form => BadRequest(s"Binding failed '${form.errors}'"),
      entity => {
        repository add entity
        Ok
      })
  }

  def list: Action[AnyContent] = Action {
    Ok(repository.list.toString)
  }

  def find(id: Int): Action[AnyContent] = Action {
    Ok(repository.find(id).toString)
  }

}
