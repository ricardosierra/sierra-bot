package com.inno.sierra.bot.commands

import com.inno.sierra.bot.MessagesText
import com.typesafe.scalalogging.LazyLogging
import info.mukel.telegrambot4s.models.Message

object Info extends LazyLogging {
  def execute(msg: Message): String = {
    MessagesText.INFO
  }
}