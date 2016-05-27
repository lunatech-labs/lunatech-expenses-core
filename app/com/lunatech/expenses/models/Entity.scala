package com.lunatech.expenses.models

trait Entity[E <: Entity[E]] {

  def withId(id: Int): E

}
