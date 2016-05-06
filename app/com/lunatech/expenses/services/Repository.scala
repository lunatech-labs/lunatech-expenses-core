package com.lunatech.expenses.services

class Repository[T] {

  var entities: Seq[T] = Seq()

  def add(entity: T): Unit = {
    entities = entities :+ entity
  }

  def list : Seq[T] = entities

}
