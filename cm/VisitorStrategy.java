package cm;

import java.math.BigDecimal;

public class VisitorStrategy implements  RateStrategy{

    public VisitorStrategy(){
    }

    @Override
    public BigDecimal strategyCalculation(BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate,
                                          BigDecimal normalRateHours, BigDecimal reducedRateHours) {
        BigDecimal result = (hourlyNormalRate.multiply(normalRateHours)).add(
                hourlyReducedRate.multiply(reducedRateHours));
        if(result.compareTo(BigDecimal.valueOf(10)) >= 0){
            result = result.subtract(BigDecimal.valueOf(10));
            result = result.multiply(BigDecimal.valueOf(0.5));
        }

        return result;
    }
}
