package cm;

import java.math.BigDecimal;

public class StudentStrategy implements  RateStrategy{

    public StudentStrategy(){
    }

    @Override
    public BigDecimal strategyCalculation(BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate,
                                          BigDecimal normalRateHours, BigDecimal reducedRateHours) {

        BigDecimal result = (hourlyNormalRate.multiply(normalRateHours)).add(
                hourlyReducedRate.multiply(reducedRateHours));

        if(result.compareTo(BigDecimal.valueOf(5.5)) > 0){
            result = result.multiply(BigDecimal.valueOf(0.75));
        }

        return result;
    }
}
