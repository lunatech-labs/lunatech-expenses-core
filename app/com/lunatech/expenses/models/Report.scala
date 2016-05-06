package com.lunatech.expenses.core

import java.time.LocalDateTime

case class Report(
                   expenses: Seq[Expense],
                   submissionDate: LocalDateTime,
                   user: User = User("", "", "") //TODO undo default
                 ) {

  def addExpenses(newExpenses: Expense*): Report = {
    this.copy(expenses = expenses ++ newExpenses)
  }

  def calculateTotal: Double = {
    expenses.foldLeft(0.0)((acc, ex) => acc + ex.total)
  }

}
