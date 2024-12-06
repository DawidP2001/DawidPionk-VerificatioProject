package cm;

import java.math.BigDecimal;

public class VisitorStrategy implements  RateStrategy{

    public VisitorStrategy(){
    }

    @Override
    public BigDecimal strategyCalculation(BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate,
                                          BigDecimal normalRateHours, BigDecimal reducedRateHours) {
        BigDecimal result = hourlyNormalRate.multiply((hourlyNormalRate.multiply(normalRateHours)).add(
                hourlyReducedRate.multiply(reducedRateHours)));

        if(result.compareTo(BigDecimal.valueOf(10)) > 0){
            return BigDecimal.valueOf(0);
        }

        return result;
    }
}
