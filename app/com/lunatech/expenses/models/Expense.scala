package com.lunatech.expenses.core

import java.net.URI
import java.time.LocalDateTime

case class Expense(
                    merchant: String,
                    total: Double,
                    date: Option[LocalDateTime] = None,
                    category: Option[Category] = None,
                    comment: Option[String] = None,
                    attachment: Option[URI] = None
                  )
{
  require(total > 0)
}

