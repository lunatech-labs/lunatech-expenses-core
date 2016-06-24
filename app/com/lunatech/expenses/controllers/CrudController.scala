package com.lunatech.expenses.controllers

import com.lunatech.expenses.models.Entity
import com.lunatech.expenses.services.Repository
import play.api.data.{Form, Mapping}
import play.api.libs.json.{JsObject, Json}
import play.api.mvc.{Action, AnyContent, Controller}

abstract class CrudController[T <: Entity[T]] extends Controller {

  def repository: Repository[T]

  protected def formMapping: Mapping[T]

  def create: Action[AnyContent] = Action { implicit request =>
    Form(formMapping).bindFromRequest().fold(
      form => BadRequest(s"Binding failed '${form.errors}'"),
      entity => {
        repository add entity
        Ok
      })
  }

  def list: Action[AnyContent] = Action {
    val seqOfJs: Seq[JsObject] = repository.list.map(toJson)
    Ok(Json.toJson(seqOfJs))
  }

  def find(id: Int): Action[AnyContent] = Action { request =>
    repository.find(id).map{
      e => Ok(toJson(e))
    }.getOrElse(NotFound)
  }

  def toJson(entity: T): JsObject

}
