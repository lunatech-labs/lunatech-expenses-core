package com.lunatech.expenses.core

import java.time.LocalDateTime
import java.time.LocalDateTime._

import org.scalatest.{FlatSpec, Matchers}

class ExpensesTest extends FlatSpec with Matchers {

  val nowDate: LocalDateTime = now()
  val expense = Expense("merchant", 10, nowDate, Hardware, "comment", None)

  "An Expense" should "reject non positive values" in {
    a [Exception] should be thrownBy {
      expense.copy(total = 0)
    }
    a [Exception] should be thrownBy {
      expense.copy(total = -10)
    }
  }
}
