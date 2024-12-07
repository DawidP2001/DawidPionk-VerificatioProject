package cm;

import java.math.BigDecimal;

/**
 * This interface is used to implement a strategy pattern for the rate class for each
 * type of car park kind.
 */
public interface RateStrategy {

    /**
     * This function is used to calculate the specific rate for each car park kind
     * @param hourlyNormalRate  The rate for an hour during the normal periods
     * @param hourlyReducedRate The rate for an hour during the reduced periods
     * @param normalRateHours   The amount of hours spent inside a normal rate period
     * @param reducedRateHours  The amount of hours spent inside a reduced rate period
     * @return  The rate the person needs to pay for their stay period based on their specific car park kind
     */
    BigDecimal strategyCalculation(BigDecimal hourlyNormalRate, BigDecimal hourlyReducedRate,
                                   BigDecimal normalRateHours, BigDecimal reducedRateHours);
}
