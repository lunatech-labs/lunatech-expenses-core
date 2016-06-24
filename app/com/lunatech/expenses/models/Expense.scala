package com.lunatech.expenses.models

import java.net.URI

import org.joda.time.DateTime
import org.joda.time.DateTime._
import play.api.libs.json.{JsString, Json, Writes}

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

object Expense {

  implicit val writesUri: Writes[URI] = Writes(uri => JsString(uri.toString))
  implicit val writesCategory: Writes[Category] = Writes(category => JsString("bla"))
  implicit val writesExpense = Json.writes[Expense]

}