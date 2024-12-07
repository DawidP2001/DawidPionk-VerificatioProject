package cm;

import java.math.BigDecimal;

/**
 * This class holds the strategy for the staff Car Park Kind
 */
public class StaffStrategy implements  RateStrategy{

    public StaffStrategy(){
    }

    @Override
    public BigDecimal strategyCalculation(BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate,
                                          BigDecimal normalRateHours, BigDecimal reducedRateHours) {

        BigDecimal result = (hourlyNormalRate.multiply(normalRateHours)).add(
                hourlyReducedRate.multiply(reducedRateHours));

        if (result.compareTo(BigDecimal.valueOf(16)) > 0){
            result = BigDecimal.valueOf(16);
        }

        return result;
    }
}
