package traderx.morphir.rulesengine

/** Generated based on Morphir.Rulesengine.Sell
*/
object Sell{

  def sell[A]: A => morphir.sdk.Basics.Bool =
    ({
      case _ => 
        false
    } : A => morphir.sdk.Basics.Bool)

}