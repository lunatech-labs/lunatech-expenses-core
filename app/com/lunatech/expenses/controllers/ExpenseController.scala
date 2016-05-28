package com.lunatech.expenses.controllers

import java.net.URI

import com.lunatech.expenses.models.{Category, EntityDTO, Expense, ExpenseDTO}
import com.lunatech.expenses.util.SimpleFormatter._
import org.joda.time.DateTime
import play.api.data.Forms._
import play.api.data.format.Formats._

class ExpenseController extends CrudController[Expense] {

  override def formMapping = mapping(
    "merchant" -> text,
    "total" -> of(doubleFormat),
    "date" -> of(jodaDateTimeFormat),
    "category" -> of(format(Category.fromString)),
    "comment" -> optional(text),
    "attachment" -> optional(of(format(new URI(_))))
  )(toDTO)(fromDTO)

  //TODO why necessary to compile?
  def toDTO(merchant: String, total: Double, date: DateTime, category: Category,
            comment: Option[String], attachment: Option[URI]): EntityDTO[Expense] = {
    ExpenseDTO.apply(merchant, total, date, category, comment, attachment)
  }

  def fromDTO(dto: EntityDTO[Expense]): Option[(String, Double, DateTime,
    Category, Option[String], Option[URI])] = dto match {
      case castedDTO: ExpenseDTO => ExpenseDTO.unapply(castedDTO)
      case _ => ???
  }

}
