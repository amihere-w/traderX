package finos.traderx.tradeprocessor;

import morphir.sdk.Bool;
import morphir.sdk.Dict;
import morphir.sdk.Result;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import scala.Function1;
import traderx.morphir.rulesengine.BuyRule;
import traderx.morphir.rulesengine.CancelTradeRule;
import traderx.morphir.rulesengine.SellRule;
import traderx.morphir.rulesengine.models.ClientOrder;
import traderx.morphir.rulesengine.models.Error;
import traderx.morphir.rulesengine.models.Market;
import traderx.morphir.rulesengine.models.Trade;

@Component
@Aspect
public class ValidateAspect {

  static Logger lg = LoggerFactory.getLogger(ValidateAspect.class);

  @Around(value = "@annotation(org.finos.trigger.ValidateBuy)")
  public Object validateBuy(ProceedingJoinPoint joinPoint) throws Throwable {

    lg.warn("running validate buy");
    Object[] args = joinPoint.getArgs();
    ClientOrder.ClientOrder order = (ClientOrder.ClientOrder)args[0];
    Market.Market market = (Market.Market)args[1];

    Result<Error.Error, Object> result = BuyRule.buyStock(order, market);
    if (result.isErr()) {
      throw new Exception("Could not perform buy action.");
    }

    return joinPoint.proceed();
  }

  @Around(value = "@annotation(org.finos.trigger.ValidateBuy)")
  public Object validateSell(ProceedingJoinPoint joinPoint) throws Throwable {

    lg.warn("running validate sell");
    Object[] args = joinPoint.getArgs();
    ClientOrder.ClientOrder order = (ClientOrder.ClientOrder)args[0];
    Market.Market market = (Market.Market)args[1];

    SellRule.sell();

    return joinPoint.proceed();
  }
  @Around(value = "@annotation(org.finos.trigger.ValidateCancel)")
  public Object validateCancel(ProceedingJoinPoint joinPoint) throws Throwable {

    lg.warn("running validate cancel");

    Object[] args = joinPoint.getArgs();

    Trade.Trade trade = (Trade.Trade)args[0];
    Market.Market market = (Market.Market)args[1];
    Result<Error.Errors, Object> result =
        CancelTradeRule.cancelTrade(trade, market);
    if (result.isErr()) {
      throw new Exception("Could not perform cancel");
    }

    return joinPoint.proceed();
  }
}
