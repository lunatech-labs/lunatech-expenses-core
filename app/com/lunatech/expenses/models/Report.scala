package com.lunatech.expenses.models

import org.joda.time.DateTime
import play.api.libs.json.Json

case class Report(
                   id: Option[Int] = None,
                   expenses: Seq[Expense],
                   submissionDate: DateTime,
                   user: User
                 ) extends Entity[Report] {

  def addExpenses(newExpenses: Expense*): Report = {
    this.copy(expenses = expenses ++ newExpenses)
  }

  def calculateTotal: Double = {
    expenses.foldLeft(0.0)((acc, ex) => acc + ex.total)
  }

  override def withId(id: Int): Report = this.copy(id = Some(id))
}

object Report {

  implicit val writesExpense = Expense.writesExpense
  implicit val writesUser = User.writesUser
  implicit val writesReport = Json.writes[Report]

}