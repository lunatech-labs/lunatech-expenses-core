package com.lunatech.expenses.services

import com.lunatech.expenses.core.Expense

class MemoryStorage {

  var expenses: Seq[Expense] = Seq()

  def addExpense(entity: Expense): Unit = {
    expenses = expenses :+ entity
  }

  def getExpenses = expenses

}
