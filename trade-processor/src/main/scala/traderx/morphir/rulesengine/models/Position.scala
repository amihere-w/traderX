package traderx.morphir.rulesengine.models

/** Generated based on Morphir.Rulesengine.Models.Position
*/
object Position{

  final case class Position(
    accountId: morphir.sdk.Basics.Int,
    security: morphir.sdk.String.String,
    quantity: morphir.sdk.Basics.Int,
    updated: morphir.sdk.String.String
  ){}

}