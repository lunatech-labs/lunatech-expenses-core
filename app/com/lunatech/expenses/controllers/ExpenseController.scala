package com.lunatech.expenses.controllers

import com.lunatech.expenses.core.Expense
import com.lunatech.expenses.services.Repository
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
        "category" -> text,
        "comment" -> optional(text),
        "attachment" -> optional(text)
      )(Expense.applyParams)(Expense.unapplyParams)
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

