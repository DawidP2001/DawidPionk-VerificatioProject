package cm;

import java.math.BigDecimal;

public class VisitorStrategy implements  RateStrategy{
    private Period period;

    public VisitorStrategy(Period period){

    }

    @Override
    public BigDecimal calculate() {
        BigDecimal result = hourlyNormalRate.multiply((this.hourlyNormalRate.multiply(normalRateHours)).add(
                this.hourlyReducedRate.multiply(reducedRateHours)));

        if(result.compareTo(BigDecimal.valueOf(10)) <= 0){
            return BigDecimal.valueOf(0);
        }

        return result;
    }
}
