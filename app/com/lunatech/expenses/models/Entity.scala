package com.lunatech.expenses.models

trait Entity[T] {

  def id: Option[Int]

  def withId(id: Int): T

}
