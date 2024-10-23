package traderx.morphir.rulesengine.models

/** Generated based on Morphir.Rulesengine.Models.Market
*/
object Market{

  type Market = morphir.sdk.Dict.Dict[traderx.morphir.rulesengine.models.Market.Stock, traderx.morphir.rulesengine.models.Market.StockDetails]
  
  sealed trait MarketStatus {
  
    
  
  }
  
  object MarketStatus{
  
    case object CLOSED extends traderx.morphir.rulesengine.models.Market.MarketStatus{}
    
    case object DFD extends traderx.morphir.rulesengine.models.Market.MarketStatus{}
    
    case object OPEN extends traderx.morphir.rulesengine.models.Market.MarketStatus{}
  
  }
  
  val CLOSED: traderx.morphir.rulesengine.models.Market.MarketStatus.CLOSED.type  = traderx.morphir.rulesengine.models.Market.MarketStatus.CLOSED
  
  val DFD: traderx.morphir.rulesengine.models.Market.MarketStatus.DFD.type  = traderx.morphir.rulesengine.models.Market.MarketStatus.DFD
  
  val OPEN: traderx.morphir.rulesengine.models.Market.MarketStatus.OPEN.type  = traderx.morphir.rulesengine.models.Market.MarketStatus.OPEN
  
  type Stock = morphir.sdk.String.String
  
  final case class StockDetails(
    floatingQty: morphir.sdk.Basics.Int,
    price: morphir.sdk.Basics.Float,
    marketStatus: traderx.morphir.rulesengine.models.Market.MarketStatus
  ){}

}