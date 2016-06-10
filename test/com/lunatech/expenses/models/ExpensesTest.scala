package com.lunatech.expenses.models

import com.lunatech.expenses.util.DefaultObjects._
import org.scalatest.{FlatSpec, Matchers}

class ExpensesTest extends FlatSpec with Matchers {

  "An Expense" should "reject non positive values" in {
    a [Exception] should be thrownBy {
      expense.copy(total = 0)
    }
    a [Exception] should be thrownBy {
      expense.copy(total = -10)
    }
  }

}
