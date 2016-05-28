package com.lunatech.expenses.controllers

import com.lunatech.expenses.models._
import org.joda.time.DateTime
import play.api.data.Forms._
import play.api.data.format.Formats._

class ReportController extends CrudController[Report] {

  override def formMapping = mapping(
    "date" -> of(jodaDateTimeFormat)
  )(toDTO)(fromDTO)

  //TODO why necessary to compile?
  def toDTO(date: DateTime): EntityDTO[Report] = {
    ReportDTO.apply(date)
  }

  def fromDTO(dto: EntityDTO[Report]): Option[(DateTime)] = dto match {
    case castedDTO: ReportDTO => ReportDTO.unapply(castedDTO)
    case _ => ???
  }

}
