package com.lunatech.expenses.core

import java.time.LocalDateTime

case class Report(expenses: Seq[Expense], submissionDate: LocalDateTime, user: User)
