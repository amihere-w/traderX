package traderx.morphir.rulesengine.models

/** Generated based on Morphir.Rulesengine.Models.Trade
*/
object Trade{

  final case class Trade(
    id: morphir.sdk.String.String,
    accountId: morphir.sdk.Basics.Int,
    security: morphir.sdk.String.String,
    side: traderx.morphir.rulesengine.models.TradeSide.TradeSide,
    state: traderx.morphir.rulesengine.models.TradeState.TradeState,
    quantity: morphir.sdk.Basics.Int
  ){}

}