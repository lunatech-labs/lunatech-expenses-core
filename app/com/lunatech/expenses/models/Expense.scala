package com.lunatech.expenses.core

import org.joda.time.DateTime
import org.joda.time.DateTime._

case class Expense(
                    merchant: String,
                    total: Double,
                    date: Option[DateTime] = Some(now()), //TODO remove default
                    category : Category,
                    comment: Option[String] = Some(""),
                    attachment: Option[String] = None
                  ) {

  require(total > 0)

}

