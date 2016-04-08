package com.lunatech.expenses.controllers

import com.lunatech.expenses.core.Expense
import play.api.mvc.{Action, AnyContent, Controller}


class ExpenseController extends Controller {

  var store: Seq[Expense] = Seq()

  def addExpense: Action[AnyContent] = Action { request =>

    val expense = Expense(
      merchant = request.getQueryString("merchant").get,
      total = request.getQueryString("total").get.toDouble
    )

    store = store :+ expense
    Ok
  }

  def listExpenses: Action[AnyContent] = Action { request =>
    Ok(store.toString)
  }

}

