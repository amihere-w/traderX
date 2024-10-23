package traderx.morphir.rulesengine

/** Generated based on Morphir.Rulesengine.BuyRule
*/
object BuyRule{

  def buyStock(
    clientOrder: traderx.morphir.rulesengine.models.ClientOrder.ClientOrder
  )(
    market: traderx.morphir.rulesengine.models.Market.Market
  ): morphir.sdk.Result.Result[traderx.morphir.rulesengine.models.Error.Error, morphir.sdk.Basics.Bool] = {
    val orderCost: morphir.sdk.Basics.Float = morphir.sdk.Dict.get(clientOrder.security)(market) match {
      case morphir.sdk.Maybe.Just(stock) => 
        morphir.sdk.Basics.multiply(stock.price)(morphir.sdk.Basics.toFloat(clientOrder.quantity))
      case morphir.sdk.Maybe.Nothing => 
        morphir.sdk.Basics.Float(0)
    }
    
    val clientAvailableBalance: morphir.sdk.Basics.Float = clientOrder.accountInfo.accountType match {
      case traderx.morphir.rulesengine.models.ClientOrder.MARGIN => 
        morphir.sdk.Basics.multiply(clientOrder.accountInfo.cashBalance)(morphir.sdk.Basics.Float(2))
      case _ => 
        clientOrder.accountInfo.cashBalance
    }
    
    morphir.sdk.Dict.get(clientOrder.security)(market) match {
      case morphir.sdk.Maybe.Just(markt) => 
        markt.marketStatus match {
          case traderx.morphir.rulesengine.models.Market.OPEN => 
            if (morphir.sdk.Basics.lessThanOrEqual(orderCost)(clientAvailableBalance)) {
              (morphir.sdk.Result.Ok(true) : morphir.sdk.Result.Result[traderx.morphir.rulesengine.models.Error.Error, morphir.sdk.Basics.Bool])
            } else {
              (morphir.sdk.Result.Err(traderx.morphir.rulesengine.models.Error.lowClientBalanceError) : morphir.sdk.Result.Result[traderx.morphir.rulesengine.models.Error.Error, morphir.sdk.Basics.Bool])
            }
          case traderx.morphir.rulesengine.models.Market.CLOSED => 
            (morphir.sdk.Result.Err(traderx.morphir.rulesengine.models.Error.marketClosedError) : morphir.sdk.Result.Result[traderx.morphir.rulesengine.models.Error.Error, morphir.sdk.Basics.Bool])
          case traderx.morphir.rulesengine.models.Market.DFD => 
            (morphir.sdk.Result.Err(traderx.morphir.rulesengine.models.Error.marketDFDError) : morphir.sdk.Result.Result[traderx.morphir.rulesengine.models.Error.Error, morphir.sdk.Basics.Bool])
        }
      case morphir.sdk.Maybe.Nothing => 
        (morphir.sdk.Result.Err(traderx.morphir.rulesengine.models.Error.stockNotFoundError) : morphir.sdk.Result.Result[traderx.morphir.rulesengine.models.Error.Error, morphir.sdk.Basics.Bool])
    }
  }

}