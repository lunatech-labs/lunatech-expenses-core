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
                  ) extends Entity[Expense] {
  require(total > 0)

  override def withId(id: Int): Expense = this.copy(id = Some(id))

}
