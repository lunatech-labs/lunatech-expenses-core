package com.lunatech.expenses.core

import java.net.URI
import java.time.LocalDateTime

case class Expense(
                    merchant: String,
                    total: Double,
                    date: LocalDateTime,
                    category: Category,
                    comment: String,
                    attachment: Option[URI]
                  )
{
  require(total > 0)
}

