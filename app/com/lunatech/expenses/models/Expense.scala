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

object Expense {

  def applyParams(
             merchant: String,
             total: Double,
             date: DateTime,
             category: String,
             comment: Option[String],
             attachment: Option[String]
           ): Expense = {
    apply(
      merchant,
      total,
      date,
      Category.fromString(category),
      comment,
      attachment.map(new URI(_))
    )
  }

  def unapplyParams(arg: Expense) =
    Some(
      arg.merchant,
      arg.total,
      arg.date,
      arg.category.toString,
      arg.comment,
      arg.attachment.map(_.toString)
    )

}

