package crypto

sealed trait Mode

case object EBC extends Mode
case object CBC extends Mode
case object GCM extends Mode
