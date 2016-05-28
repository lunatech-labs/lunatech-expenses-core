package com.lunatech.expenses.controllers

import com.lunatech.expenses.models._
import org.joda.time.DateTime
import play.api.data.Forms._
import play.api.data.format.Formats._

class ReportController extends CrudController[Report] {

  override def formMapping = mapping(
    "date" -> of(jodaDateTimeFormat)
  )(marshall)(unmarshall)

  def marshall(date: DateTime): Report =
    Report(None, Seq(), date, User("", "", ""))

  def unmarshall(entity: Report): Option[(DateTime)] =
    Some(entity.submissionDate)

}
