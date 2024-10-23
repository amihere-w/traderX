package traderx.morphir.rulesengine

/** Generated based on Morphir.Rulesengine.Validation
*/
object Validation{

  def validateRequest(
    cOrder: traderx.morphir.rulesengine.models.ClientOrder.ClientOrder
  ): traderx.morphir.rulesengine.models.Trade.Trade => morphir.sdk.Result.Result[traderx.morphir.rulesengine.models.Error.Error, traderx.morphir.rulesengine.models.ClientOrder.ClientOrder] =
    ({
      case _ => 
        (morphir.sdk.Result.Ok(cOrder) : morphir.sdk.Result.Result[traderx.morphir.rulesengine.models.Error.Error, traderx.morphir.rulesengine.models.ClientOrder.ClientOrder])
    } : traderx.morphir.rulesengine.models.Trade.Trade => morphir.sdk.Result.Result[traderx.morphir.rulesengine.models.Error.Error, traderx.morphir.rulesengine.models.ClientOrder.ClientOrder])

}