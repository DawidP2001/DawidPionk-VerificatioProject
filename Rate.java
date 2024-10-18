import java.util.ArrayList;

public class Rate {
    private CarParkKind kind;
    private double hourlyNormalRate;
    private double hourlyReducedRate;

    public Rate(
        CarParkKind kind,
        ArrayList<Period> reducedPeriods,
        ArrayList<Period> normalPeriods,
        double normalRate,
        double reducedRate
    ){

    }
    public void setKind(CarParkKind kind) {
        this.kind = kind;
    };
    public void setHourlyNormalRate(double hourlyNormalRate) {
        this.hourlyNormalRate = hourlyNormalRate;
    }
    public void setHourlyReducedRate(double hourlyReducedRate) {
        this.hourlyReducedRate = hourlyReducedRate;
    }
    public double getHourlyNormalRate() {
        return hourlyNormalRate;
    }
    public double getHourlyReducedRate() {
        return hourlyReducedRate;
    }
    public CarParkKind getKind() {
        return kind;
    }
    public double calculate(Period period){
        return 0.0;
    }
}
