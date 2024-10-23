package traderx.morphir.rulesengine.models

/** Generated based on Morphir.Rulesengine.Models.ClientOrder
*/
object ClientOrder{

  final case class AccountInfo(
    accountType: traderx.morphir.rulesengine.models.ClientOrder.AccountType,
    stocks: morphir.sdk.Maybe.Maybe[morphir.sdk.List.List[traderx.morphir.rulesengine.models.ClientOrder.ClientStock]],
    cashBalance: morphir.sdk.Basics.Float
  ){}
  
  sealed trait AccountType {
  
    
  
  }
  
  object AccountType{
  
    case object CASH extends traderx.morphir.rulesengine.models.ClientOrder.AccountType{}
    
    case object FIRMACCOUNT extends traderx.morphir.rulesengine.models.ClientOrder.AccountType{}
    
    case object MARGIN extends traderx.morphir.rulesengine.models.ClientOrder.AccountType{}
  
  }
  
  val CASH: traderx.morphir.rulesengine.models.ClientOrder.AccountType.CASH.type  = traderx.morphir.rulesengine.models.ClientOrder.AccountType.CASH
  
  val FIRMACCOUNT: traderx.morphir.rulesengine.models.ClientOrder.AccountType.FIRMACCOUNT.type  = traderx.morphir.rulesengine.models.ClientOrder.AccountType.FIRMACCOUNT
  
  val MARGIN: traderx.morphir.rulesengine.models.ClientOrder.AccountType.MARGIN.type  = traderx.morphir.rulesengine.models.ClientOrder.AccountType.MARGIN
  
  final case class ClientOrder(
    orderId: morphir.sdk.String.String,
    security: morphir.sdk.String.String,
    side: traderx.morphir.rulesengine.models.TradeSide.TradeSide,
    quantity: morphir.sdk.Basics.Int,
    accountInfo: traderx.morphir.rulesengine.models.ClientOrder.AccountInfo
  ){}
  
  final case class ClientStock(
    stock: traderx.morphir.rulesengine.models.Market.Stock,
    quantity: morphir.sdk.Basics.Int
  ){}

}