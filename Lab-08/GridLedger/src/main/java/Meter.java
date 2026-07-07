public class Meter {
    private double units;

    public Meter(double units){
        if(units<0) throw new IllegalArgumentException("Units cannot be negative");
        this.units=units;
    }

    public double getUnits(){
        return units;
    }
}
