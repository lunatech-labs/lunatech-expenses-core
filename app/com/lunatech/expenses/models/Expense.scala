package com.lunatech.expenses.models

import java.net.URI

import org.joda.time.DateTime
import org.joda.time.DateTime._

case class Expense(
                    id: Option[Int] = None,
                    merchant: String,
                    total: Double,
                    date: DateTime = now(),
                    category: Category,
                    comment: Option[String] = None,
                    attachment: Option[URI] = None
                  ) {
  require(total > 0)
}
