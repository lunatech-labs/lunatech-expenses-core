package com.lunatech.expenses.models

import java.net.URI

import org.joda.time.DateTime
import org.joda.time.DateTime._

trait EntityDTO[T] {
    def toEntity: T
}

case class ExpenseDTO(merchant: String, total: Double, date: DateTime = now(),
                      category: Category, comment: Option[String] = None,
                      attachment: Option[URI] = None) extends EntityDTO[Expense] {
  def toEntity: Expense = {
    Expense(None, merchant, total, date, category, comment, attachment)
  }

}

case class ReportDTO(date: DateTime) extends EntityDTO[Report] {
  def toEntity: Report = {
    Report(None, Seq(), date, User("", "", ""))
  }
}
