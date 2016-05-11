package com.lunatech.expenses.controllers

import java.net.URI

import com.lunatech.expenses.core.{Category, Expense}
import com.lunatech.expenses.services.Repository
import com.lunatech.expenses.util.SimpleFormatter._
import play.api.data.Form
import play.api.data.Forms._
import play.api.data.format.Formats._
import play.api.mvc.{Action, AnyContent, Controller}

class ExpenseController extends Controller {

  val repository: Repository[Expense] = new Repository[Expense]

  def addExpense: Action[AnyContent] = Action { implicit request =>

    val form = Form(
      mapping(
        "merchant" -> text,
        "total" -> of(doubleFormat),
        "date" -> of(jodaDateTimeFormat),
        "category" -> of(format(Category.fromString)),
        "comment" -> optional(text),
        "attachment" -> optional(of(format(new URI(_))))
      )(Expense.apply)(Expense.unapply)
    )

    form.bindFromRequest().fold(
      f => BadRequest(s"Binding failed '${f.errors}'"),
      e => {
        repository add e
        Ok
      })

  }

  def listExpenses: Action[AnyContent] = Action { request =>
    val result: String = repository.list.toString
    Ok(result)
  }

}

