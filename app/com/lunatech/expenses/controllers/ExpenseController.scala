package com.lunatech.expenses.controllers

import java.net.URI

import com.lunatech.expenses.models.{Category, Expense}
import com.lunatech.expenses.services.Repository
import com.lunatech.expenses.util.SimpleFormatter._
import org.joda.time.DateTime
import play.api.data.Forms._
import play.api.data.format.Formats._

class ExpenseController extends CrudController[Expense] {

  def repository = Repository.expense

  override def formMapping = mapping(
    "merchant" -> text,
    "total" -> of(doubleFormat),
    "date" -> of(jodaDateTimeFormat),
    "category" -> of(format(Category.fromString)),
    "comment" -> optional(text),
    "attachment" -> optional(of(format(new URI(_))))
  )(marshall)(unmarshall)

  private def marshall(merchant: String, total: Double, date: DateTime, category: Category,
               comment: Option[String], attachment: Option[URI]): Expense =
    Expense(None, merchant, total, date, category, comment, attachment)

  private def unmarshall(entity: Expense): Option[(String, Double, DateTime, Category, Option[String], Option[URI])] =
    Some(entity.merchant, entity.total, entity.date, entity.category, entity.comment, entity.attachment)

}
