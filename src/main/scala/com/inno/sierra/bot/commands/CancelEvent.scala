package com.inno.sierra.bot.commands

import com.inno.sierra.bot.{MessagesText, SierraBot}
import com.inno.sierra.model.{ChatSessionEvents, DbSchema, Event}
import info.mukel.telegrambot4s.api.Extractors
import info.mukel.telegrambot4s.models.{CallbackQuery, InlineKeyboardButton, InlineKeyboardMarkup, Message}

/**
  * Cancels the event by id or with using GUI.
  */
object CancelEvent {

  /**
    * Executes the command.
    * @param msg  the message to process
    * @return response to the user
    */
  def execute(bot: SierraBot)(implicit msg: Message): Unit = {
    val args = Extractors.commandArguments(msg).get

    if (args.isEmpty) {
      val events = DbSchema.getAllUpcomingEventsForUser(msg.chat.id)
      if (events.nonEmpty) {
        val buttons = events.map(e =>
          InlineKeyboardButton.callbackData(e.name, "event-" + e.id))
        bot.reply("Choose the event to cancel", replyMarkup = Some(InlineKeyboardMarkup(Seq(buttons))))
      } else {
        bot.reply("You have no scheduled events")
      }
    } else {
      removeEvent(args.head.toInt, bot)
    }
  }

  def onCallbackWithTagEvent(bot: SierraBot)(implicit cbq: CallbackQuery): Unit = {
    bot.ackCallback()
    removeEvent(cbq.data.get.toInt, bot)(cbq.message.get)
  }

  private def removeEvent(id: Int, bot: SierraBot)(implicit msg: Message): Unit = {
    if (DbSchema.getEntityById[Event](id).nonEmpty) {
      DbSchema.delete[ChatSessionEvents](id)
      DbSchema.delete[Event](id)
      bot.reply(MessagesText.CANCEL_DONE)
    } else {
      bot.reply(MessagesText.CANCEL_FAILED)
    }
  }

}
