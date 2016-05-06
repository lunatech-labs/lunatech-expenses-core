package com.lunatech.expenses.controllers

import com.lunatech.expenses.core.Expense
import com.lunatech.expenses.services.MemoryRepository
import play.api.mvc.{Action, AnyContent, Controller}

class ExpenseController extends Controller {

  def addExpense: Action[AnyContent] = Action { request =>

    val expense = Expense(
      merchant = request.getQueryString("merchant").get,
      total = request.getQueryString("total").get.toDouble
    )

    MemoryRepository add expense
    Ok
  }

  def listExpenses: Action[AnyContent] = Action { request =>
    val result: String = MemoryRepository.get(Expense.getClass).toString
    Ok(result)
  }

}

