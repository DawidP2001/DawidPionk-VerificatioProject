import java.util.ArrayList;
import java.math.BigDecimal;

public class Rate {
    private CarParkKind kind;
    private BigDecimal hourlyNormalRate;
    private BigDecimal hourlyReducedRate;

    public Rate(
        CarParkKind kind,
        ArrayList<Period> reducedPeriods,
        ArrayList<Period> normalPeriods,
        BigDecimal normalRate,
        BigDecimal reducedRate
    ){
        setKind(kind);
        setHourlyNormalRate(normalRate);
        setHourlyReducedRate(reducedRate);
    }
    public void setKind(CarParkKind kind) {
        this.kind = kind;
    };
    public void setHourlyNormalRate(BigDecimal hourlyNormalRate) {
        this.hourlyNormalRate = hourlyNormalRate;
    }
    public void setHourlyReducedRate(BigDecimal hourlyReducedRate) {
        this.hourlyReducedRate = hourlyReducedRate;
    }
    public BigDecimal getHourlyReducedRate() {
        return null;
    }
    public BigDecimal getHourlyNormalRate() {
        return hourlyNormalRate;
    }
    public CarParkKind getKind() {
        return null;
    }
    public BigDecimal calculate(Period period){
        return null;
    }
}
