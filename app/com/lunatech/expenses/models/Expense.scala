package com.lunatech.expenses.core

import java.net.URI

import com.lunatech.expenses.util.CustomMapping
import org.joda.time.DateTime
import org.joda.time.DateTime._
import play.api.data.Mapping

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

  def attachmentMapping: Mapping[Option[URI]] = new CustomMapping[Option[URI]] {
    override val key: String = "attachment"
    override def bind(param: Option[String]) = Right(param.map(new URI(_)))
  }

}

