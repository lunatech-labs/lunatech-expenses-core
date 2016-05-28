package com.lunatech.expenses.models

trait Entity[T] {

  def withId(id: Int): T

}
