package com.lunatech.expenses.controllers

import com.lunatech.expenses.core.Expense
import com.lunatech.expenses.services.MemoryStorage
import play.api.mvc.{Action, AnyContent, Controller}


class ExpenseController extends Controller {

  var repository = new MemoryStorage()

  def addExpense: Action[AnyContent] = Action { request =>

    val expense = Expense(
      merchant = request.getQueryString("merchant").get,
      total = request.getQueryString("total").get.toDouble
    )

    repository addExpense expense
    Ok
  }

  def listExpenses: Action[AnyContent] = Action { request =>
    val result: String = repository.getExpenses.toString
    Ok(result)
  }

}

