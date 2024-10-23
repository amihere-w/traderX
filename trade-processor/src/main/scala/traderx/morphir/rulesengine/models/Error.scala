package traderx.morphir.rulesengine.models

/** Generated based on Morphir.Rulesengine.Models.Error
*/
object Error{

  final case class Error(
    code: morphir.sdk.Basics.Int,
    msg: morphir.sdk.String.String
  ){}
  
  def lowClientBalanceError: traderx.morphir.rulesengine.models.Error.Error =
    traderx.morphir.rulesengine.models.Error.Error(
      code = morphir.sdk.Basics.Int(404),
      msg = """Stock Not Found In Market"""
    )
  
  def marketClosedError: traderx.morphir.rulesengine.models.Error.Error =
    traderx.morphir.rulesengine.models.Error.Error(
      code = morphir.sdk.Basics.Int(600),
      msg = """Market is Closed"""
    )
  
  def marketDFDError: traderx.morphir.rulesengine.models.Error.Error =
    traderx.morphir.rulesengine.models.Error.Error(
      code = morphir.sdk.Basics.Int(550),
      msg = """Market is Done-For-Day"""
    )
  
  def stockNotFoundError: traderx.morphir.rulesengine.models.Error.Error =
    traderx.morphir.rulesengine.models.Error.Error(
      code = morphir.sdk.Basics.Int(404),
      msg = """Stock Not Found In Market"""
    )

}