public class Period {
    private int startHour;
    private int endHour;

    public Period(int startHour, int endHour){
        setStartHour(startHour);
        setEndHour(endHour);
    }
    public Period(){
        
    }
    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }
    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }
    public int getStartHour() {
        return startHour;
    }
    public int getEndHour() {
        return endHour;
    }
    public int duration(){
        return 0;
    }
    public boolean overlap(Period period){
        return true;
    }
}
