package com.scala.helloworld

import scala.util.Random

object PatternMatching {
  def main(args: Array[String]): Unit = {
    println(matchTest(Random.nextInt(10)))

    val sms = SMS("1234", "Hello")
    val email = Email("vasya", "hi", "hi all")
    val recording = VoiceRecording("vasya", "link")
    val info = Seq("vasya")

    println(showNotification(sms, info))
    println(showNotification(email, info))
    println(showNotification(recording, info))
  }

  def matchTest(value: Int): String = {
    value match {
      case 1 => s"1 = $value"
      case 2 => s"2 = $value"
      case 3 => s"3 = $value"
      case _ => s"any = $value"
    }
  }

  def showNotification(notification: Notification, info: Seq[String]): String = {
    notification match {
      case Email(email, title, _) => s"You got an email from $email with title: $title"
      case sms: SMS => sms.simpleMessage
      case VoiceRecording(name, _) if info.contains(name) => "recording"
    }
  }
}

abstract class Notification

case class Email(sender: String, title: String, body: String) extends Notification

case class SMS(caller: String, message: String) extends Notification {
  def simpleMessage = "You got sms"
}

case class VoiceRecording(contactName: String, link: String) extends Notification