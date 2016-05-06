package com.lunatech.expenses.controllers

import java.time.LocalDateTime

import com.lunatech.expenses.core.Report
import com.lunatech.expenses.services.Repository
import play.api.mvc.{Action, AnyContent, Controller}

class ReportController extends Controller {

  val repository : Repository[Report] = new Repository[Report]

  def addReport: Action[AnyContent] = Action { request =>

    val report = Report(Seq(), LocalDateTime.now())

    repository add report
    Ok
  }

  def listReports: Action[AnyContent] = Action { request =>
    val result: String = repository.list.toString
    Ok(result)
  }

}
