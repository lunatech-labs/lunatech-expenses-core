package com.lunatech.expenses.models

import com.lunatech.expenses.util.DefaultObjects._
import org.scalatest.{FlatSpec, Matchers}

class ReportsTest extends FlatSpec with Matchers {

  "A Report" should "add an Expense" in {
    val result = report.addExpenses(expense)
    result.expenses should be(Seq(expense))

    val expense2 = expense.copy(merchant = "mobile phone", category = Phone)
    val result2 = result.addExpenses(expense2)
    result2.expenses should be(Seq(expense, expense2))
  }

  it should "calculate the total value" in {
    val expense2 = expense.copy(total = 20)
    val expense3 = expense.copy(total = 15)
    val reportWithExpenses = report.addExpenses(expense, expense2, expense3)

    reportWithExpenses.calculateTotal should be (45)
  }

}
