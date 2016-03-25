package com.lunatech.expenses.core

import java.time.LocalDateTime
import java.time.LocalDateTime._

import org.scalatest.{FlatSpec, Matchers}

class ExpensesTest extends FlatSpec with Matchers {

  val user = User("User Name", "bank_account", "test@test.com")
  val nowDate: LocalDateTime = now()

  "A Report" should "add an Expense" in {

    val report = Report(Seq.empty[Expense], nowDate, user)

    val expense = Expense("merchant", 10, nowDate, Hardware, "comment", None)
    val result = report.addExpense(expense)

    result should be(Report(Seq(expense), nowDate, user))


    val expense2 = Expense("mobile phone", 10, nowDate, Phone, "comment", None)
    val result2 = result.addExpense(expense2)

    result2 should be(Report(Seq(expense2, expense), nowDate, user))
  }

  it should "calculate the total value" in {

  }

}
