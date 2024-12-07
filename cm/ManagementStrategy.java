package cm;

import java.math.BigDecimal;

/**
 * This class holds the strategy for the management Car Park Kind
 */
public class ManagementStrategy implements  RateStrategy{

    public ManagementStrategy(){
    }

    @Override
    public BigDecimal strategyCalculation(BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate,
                                          BigDecimal normalRateHours, BigDecimal reducedRateHours) {
        BigDecimal result = (hourlyNormalRate.multiply(normalRateHours)).add(
                hourlyReducedRate.multiply(reducedRateHours));
        if(result.compareTo(BigDecimal.valueOf(4)) <= 0){
            result = BigDecimal.valueOf(4);
        }

        return result;
    }
}
