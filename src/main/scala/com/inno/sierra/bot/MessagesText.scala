package com.inno.sierra.bot

object MessagesText {

  val INFO: String =
    """Telegram bot created with Scala.
      |This bot is a simple Assistant that provides the following functionality:\n
      |/start: Starts this bot.\n
      |/keepinmind: Creates an Event to Keep in Mind.\n
      |/info:  Displays description (this text).\n
      |/exit:  TODO.\n
      """.stripMargin

  val START_FIRST_TIME: String =
    """Nice to meet you, %s! I can help
      |you to plan your activities. I'll try to be useful for you :)
    """.stripMargin

  val START_AGAIN: String =
    """Welcome back, %s! I'm glad to see you again :)
      |How can I help you?
    """.stripMargin

  val SUBSCRIBE_DONE: String =
    "Now you will be informed about the events in this group :)"

  val SUBSCRIBE_ALREADY: String =
    "You are already subscribed to the events in this chat ;)"

  val KEEPINMIND_DONE: String =
    "The event %s is recorded. I will remind you ;)"

  val KEEPINMIND_INTERSECTIONS: String =
    "I'm sorry but this event intersects with another ones:\n "

  val KEEPINMIND_NOT_ENOUGH_PARAMS: String =
    "Create an event requires 4 parameters date, hour, name and duration(min)"

  val KEEPINMIND_CORRECT_PARAMS: String =
    "Try again with correct parameters"

  val KEEPINMIND_WRONG_FORMAT_PARAM1: String =
    "The date, first parameter should follow the format dd.mm.YYYY"

  val KEEPINMIND_WRONG_FORMAT_PARAM2: String =
    "The hour, second parameter should follow the format HH:MM"

  val KEEPINMIND_WRONG_FORMAT_PARAM3: String =
    "The name, third parameter should follow the format letters and/or numbers"

  val KEEPINMIND_WRONG_FORMAT_PARAM4: String =
    "The duration, fourth parameter should be a number"

  val ERROR_UNEXPTECTED: String =
    "I'm so sorry! It seems something went wrong, try again, please."
}