package com.lunatech.expenses.controllers

import com.lunatech.expenses.models._
import com.lunatech.expenses.services.Repository
import org.joda.time.DateTime
import play.api.data.Forms._
import play.api.data.format.Formats._
import play.api.libs.json.{JsObject, Json, Writes}
import play.api.mvc.{Action, AnyContent}

class ReportController extends CrudController[Report] {

  def repository = Repository.report
  def expenseRepository = Repository.expense

  override def formMapping = mapping(
    "date" -> of(jodaDateTimeFormat)
  )(marshall)(unmarshall)

  override def toJson(report: Report): JsObject = {
    Json.obj(
      "id" -> report.id,
      "expenses" -> report.expenses.toString(),
      "submissionDate" -> report.submissionDate,
      "user" -> report.user.toString
    )
  }
  private def marshall(date: DateTime): Report =
    Report(None, Seq(), date, User("", "", ""))

  private def unmarshall(entity: Report): Option[(DateTime)] =
    Some(entity.submissionDate)

  def addExpense(idReport: Int, idExpense: Int): Action[AnyContent] = Action {
    val report = repository.find(idReport).get
    val expense = expenseRepository.find(idExpense).get
    val remainingExpenses = report.expenses.filterNot(_.id.contains(idExpense))
    val updatedExpenses = remainingExpenses :+ expense
    repository.update(report.copy(expenses = updatedExpenses))
    Ok
  }

}

object ReportController {

  implicit val writesExpense = ExpenseController.writesExpense
  implicit val writesUser = UserController.writesUser
  implicit val writesReport: Writes[Report] = Json.writes[Report]

}