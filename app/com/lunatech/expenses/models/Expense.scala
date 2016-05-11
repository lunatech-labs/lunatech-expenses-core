package com.lunatech.expenses.core

import java.net.URI

import org.joda.time.DateTime
import org.joda.time.DateTime._

case class Expense(
                    merchant: String,
                    total: Double,
                    date: DateTime = now(),
                    category: Category,
                    comment: Option[String] = Some(""),
                    attachment: Option[URI] = None) {
  require(total > 0)
}
