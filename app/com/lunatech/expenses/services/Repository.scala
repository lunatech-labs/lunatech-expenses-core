package com.lunatech.expenses.services

import com.lunatech.expenses.models.Entity

class Repository[T <: Entity[T]] {

  var entities: Seq[T] = Seq()
  var latestId: Int = 0

  def add(entity: T): Unit = {
    latestId += 1
    entities = entities :+ entity.withId(latestId)
  }

  def list : Seq[T] = entities

}
