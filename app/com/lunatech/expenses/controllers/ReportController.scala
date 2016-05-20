package com.lunatech.expenses.controllers

import com.lunatech.expenses.models.{Report, User}
import com.lunatech.expenses.services.Repository
import org.joda.time.DateTime
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._
import play.api.mvc.{Action, AnyContent, Controller}

class ReportController extends Controller {

  val repository: Repository[Report] = new Repository[Report]

  def create: Action[AnyContent] = Action { implicit request =>
    Form(
      mapping(
        "date" -> of(jodaDateTimeFormat)
      )(ReportDTO.apply)(ReportDTO.unapply)
    ).bindFromRequest().fold(
      form => BadRequest(s"Binding failed '${form.errors}'"),
      dto => {
        repository add dto.toReport
        Ok
      }
    )
  }

  def list: Action[AnyContent] = Action { request =>
    val result: String = repository.list.toString
    Ok(result)
  }

}

case class ReportDTO(date: DateTime) {
  def toReport: Report = {
    Report(None, Seq(), date, User("", "", ""))
  }
}
