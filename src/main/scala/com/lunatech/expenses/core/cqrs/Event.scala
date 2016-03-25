package com.lunatech.expenses.core.cqrs

import java.time.LocalDateTime

import cats._
import com.lunatech.expenses.core.{Expense, Report}

trait Event[+Next] {
  def at: LocalDateTime
  def next: R => Next
}

case class ReportCreated[Next](no: String, at: LocalDateTime, onInit: Report => Next) extends Event[Next]

case class ExpenseAdded[Next](no: String, at: LocalDateTime, expense: Expense, onAdd: Report => Next) extends Event[Next]

object Event {
  implicit def functor: Functor[Event] = new Functor[Event] {
    override def map[A, B](fa: Event[A])(f: (A) => B): Event[B] =
      fa match {
        case e =>

        case rc@ReportCreated(_, _, onInit) =>
          rc.copy(onInit = onInit andThen f)
        case ea@ExpenseAdded(_, _, _, onAdd) =>
          ea.copy(onAdd = onAdd andThen f)
      }
  }
}