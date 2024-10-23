package traderx.morphir.rulesengine

/** Generated based on Morphir.Rulesengine.Main
*/
object Main{

  def processTrade(
    clientOrder: traderx.morphir.rulesengine.models.ClientOrder.ClientOrder
  ): morphir.sdk.Result.Result[traderx.morphir.rulesengine.models.Error.Error, traderx.morphir.rulesengine.models.ClientOrder.ClientOrder] =
    (morphir.sdk.Result.Ok(clientOrder) : morphir.sdk.Result.Result[traderx.morphir.rulesengine.models.Error.Error, traderx.morphir.rulesengine.models.ClientOrder.ClientOrder])

}