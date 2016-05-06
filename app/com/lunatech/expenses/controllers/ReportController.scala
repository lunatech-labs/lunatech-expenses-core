package com.lunatech.expenses.controllers

import java.time.LocalDateTime

import com.lunatech.expenses.core.Report
import com.lunatech.expenses.services.MemoryRepository
import play.api.mvc.{Action, AnyContent, Controller}

class ReportController extends Controller {

  def addReport: Action[AnyContent] = Action { request =>

    val report = Report(Seq(), LocalDateTime.now())

    MemoryRepository add report
    Ok
  }

  def listReports: Action[AnyContent] = Action { request =>
    val result: String = MemoryRepository.get(Report.getClass).toString
    Ok(result)
  }

}
