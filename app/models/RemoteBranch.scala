package models

import java.util.Date

import play.api.libs.json.Json

case class RemoteBranch(
  remote : String,
  branch : String
)

object RemoteBranch extends ((
  String,
  String
) => RemoteBranch) {

  implicit val jsonFormat = Json.format[RemoteBranch]

}
