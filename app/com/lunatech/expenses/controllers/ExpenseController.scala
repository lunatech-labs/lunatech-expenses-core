package com.lunatech.expenses.controllers

import com.lunatech.expenses.core.Expense
import com.lunatech.expenses.services.Repository
import play.api.mvc.{Action, AnyContent, Controller}

class ExpenseController extends Controller {

  val repository : Repository[Expense] = new Repository[Expense]

  def addExpense: Action[AnyContent] = Action { request =>

    val expense = Expense(
      merchant = request.getQueryString("merchant").get,
      total = request.getQueryString("total").get.toDouble
    )

    repository add expense
    Ok
  }

  def listExpenses: Action[AnyContent] = Action { request =>
    val result: String = repository.list.toString
    Ok(result)
  }

}

