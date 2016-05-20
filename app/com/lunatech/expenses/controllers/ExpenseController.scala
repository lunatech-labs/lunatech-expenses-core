package com.lunatech.expenses.controllers

import java.net.URI

import com.lunatech.expenses.models.{Category, Expense}
import com.lunatech.expenses.services.Repository
import com.lunatech.expenses.util.SimpleFormatter._
import org.joda.time.DateTime
import org.joda.time.DateTime._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._
import play.api.mvc.{Action, AnyContent, Controller}

class ExpenseController extends Controller {

  val repository: Repository[Expense] = new Repository[Expense]

  def create: Action[AnyContent] = Action { implicit request =>
    Form(
      mapping(
        "merchant" -> text,
        "total" -> of(doubleFormat),
        "date" -> of(jodaDateTimeFormat),
        "category" -> of(format(Category.fromString)),
        "comment" -> optional(text),
        "attachment" -> optional(of(format(new URI(_))))
      )(ExpenseDTO.apply)(ExpenseDTO.unapply)
    ).bindFromRequest().fold(
      form => BadRequest(s"Binding failed '${form.errors}'"),
      expense => {
        repository add expense.toExpense
        Ok
      })
  }

  def list: Action[AnyContent] = Action { request =>
    val result: String = repository.list.toString
    Ok(result)
  }

}

case class ExpenseDTO(merchant: String, total: Double, date: DateTime = now(),
                      category: Category, comment: Option[String] = None,
                      attachment: Option[URI] = None) {
  def toExpense: Expense = {
    Expense(None, merchant, total, date, category, comment, attachment)
  }
}
