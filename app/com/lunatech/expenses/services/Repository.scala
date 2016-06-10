package com.lunatech.expenses.services

import com.lunatech.expenses.models.{Entity, Expense, Report}

import scala.collection.mutable

class Repository[T <: Entity[T]] {

  var entities: mutable.Map[Int, T] = mutable.Map()
  var latestId: Int = 0

  def add(entity: T): Unit = {
    latestId += 1
    entities += latestId -> entity.withId(latestId)
  }

  def list: Seq[T] = entities.map{case (key, value) => value}.toList

  def find(id: Int): Option[T] = entities.get(id)

  def update(entity: T): Unit = {
    require(entity.id.isDefined)
    entities = entities.updated(entity.id.get, entity)
  }

}

object Repository {
  val expense = new Repository[Expense]
  val report = new Repository[Report]
}
