package models

import java.util.Date

import play.api.libs.json.Json

case class PullRequest(
  from : RemoteBranch,
  to   : RemoteBranch
)

object PullRequest extends ((
  RemoteBranch,
  RemoteBranch
) => PullRequest) {

  implicit val jsonFormat = Json.format[PullRequest]

  implicit def fromForm(from:(String,String),to:(String,String)) =
    PullRequest(RemoteBranch(from._1,from._2),RemoteBranch(to._1,to._2))

  implicit def toForm(pr:PullRequest) =
    Some((pr.from.remote,pr.from.branch),(pr.to.remote,pr.to.branch))

}
