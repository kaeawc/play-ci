package git

sealed trait BisectChoice

case object Good extends BisectChoice
case object Bad extends BisectChoice
