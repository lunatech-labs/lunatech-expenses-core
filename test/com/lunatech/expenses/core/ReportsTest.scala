package com.lunatech.expenses.models

import java.time.LocalDateTime
import java.time.LocalDateTime._

import org.scalatest.{FlatSpec, Matchers}

class ReportsTest extends FlatSpec with Matchers {

  val user = User("User Name", "bank_account", "test@test.com")
  val nowDate: LocalDateTime = now()
  val expense = Expense("merchant", 10, nowDate, Hardware, "comment", None)
  val report = Report(Seq.empty[Expense], nowDate, user)

  "A Report" should "add an Expense" in {
    val result = report.addExpenses(expense)
    result should be(Report(Seq(expense), nowDate, user))

    val expense2 = expense.copy(merchant = "mobile phone", category = Phone)
    val result2 = result.addExpenses(expense2)
    result2 should be(Report(Seq(expense, expense2), nowDate, user))
  }

  it should "calculate the total value" in {
    val reportWithExpenses = report.addExpenses(expense, expense.copy(total = 20), expense.copy(total = 15))

    reportWithExpenses.calculateTotal should be (45)
  }

}
