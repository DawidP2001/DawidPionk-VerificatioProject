package cm;

import java.math.BigDecimal;

public interface RateStrategy {
    BigDecimal strategyCalculation(BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate,
                                   BigDecimal normalRateHours, BigDecimal reducedRateHours);
}
