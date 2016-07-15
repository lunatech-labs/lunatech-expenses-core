package com.lunatech.expenses.util

import com.lunatech.expenses.models.{Expense, Hardware, Report, User}
import org.joda.time.DateTime

object DefaultObjects {

  val date: DateTime = DateTime.now()
  val user = User(Some(1), "User Name", "test@test.com")
  val expense = Expense(Some(1), "merchant", 10, date, Hardware, Some("comment"), None)
  val report = Report(Some(1), Seq.empty[Expense], date, user)

}
