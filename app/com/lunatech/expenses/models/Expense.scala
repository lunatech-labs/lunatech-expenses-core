package com.lunatech.expenses.core

import java.net.URI
import java.time.LocalDateTime
import java.time.LocalDateTime._

case class Expense(
                    merchant: String,
                    total: Double,
                    date: LocalDateTime = now(), //TODO remove default
                    category: Category = Food, //TODO remove default
                    comment: String = "",
                    attachment: Option[URI] = None
                  ) {

  require(total > 0)
}

