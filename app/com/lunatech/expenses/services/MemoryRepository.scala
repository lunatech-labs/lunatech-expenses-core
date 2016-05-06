package com.lunatech.expenses.services

import com.lunatech.expenses.core.Expense

object MemoryRepository {

  var expenses: Map[Class[_], _] = Map()

  def add(entity: AnyRef): Unit = {
    expenses += (Expense.getClass -> entity)
  }

  def get[T](clazz: Class[T]) : Option[T] = expenses.get(clazz).map(_.asInstanceOf[T])

}
