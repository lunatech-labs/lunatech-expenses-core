package com.lunatech.expenses.models

import org.joda.time.DateTime

case class Report(
                   id: Option[Int] = None,
                   expenses: Seq[Expense],
                   submissionDate: DateTime,
                   user: User
                 ) {

  def addExpenses(newExpenses: Expense*): Report = {
    this.copy(expenses = expenses ++ newExpenses)
  }

  def calculateTotal: Double = {
    expenses.foldLeft(0.0)((acc, ex) => acc + ex.total)
  }

}
