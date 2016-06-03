package com.lunatech.expenses.controllers

import com.lunatech.expenses.models._
import org.joda.time.DateTime
import play.api.data.Forms._
import play.api.data.format.Formats._
import play.api.mvc.{Action, AnyContent}

class ReportController extends CrudController[Report] {

  override def formMapping = mapping(
    "date" -> of(jodaDateTimeFormat)
  )(marshall)(unmarshall)

  private def marshall(date: DateTime): Report =
    Report(None, Seq(), date, User("", "", ""))

  private def unmarshall(entity: Report): Option[(DateTime)] =
    Some(entity.submissionDate)

  def addExpense(idRep: Int, idExp: Int): Action[AnyContent] = Action {
    ???
    Ok
  }

}
