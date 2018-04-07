package com.inno.sierra.bot

import com.inno.sierra.model.{DbSchema, Event}
import info.mukel.telegrambot4s.methods.SendMessage

import scala.concurrent.{ExecutionContext, Future}

class RunnableNotification(event:Event) {

  def sendNotification()(implicit ec:ExecutionContext): Future[Unit] = Future {

    //TODO actually send notification instead printing to console
    System.out.println("Notifying about " + event.name)

    event.isNotified = true
    DbSchema.update(event)
  }
}