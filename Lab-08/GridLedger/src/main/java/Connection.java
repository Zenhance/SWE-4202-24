public abstract class Connection {
    private double fuelSurchargePercentage = 0.10;
    private double taxSurchargePercentage = 0.05;

    private Meter meter;


    public int getUnits(){
       return meter.getUnitsConsumed();
    }



    public void setMeter(Meter meter) {
        this.meter = meter;
    }

    public Connection(Meter meter) {
        setMeter(meter);
    }

    abstract public double energyCharge();
    abstract public double fixedCharge();

    public double fuelSurcharge() {
        return energyCharge() * fuelSurchargePercentage;
    }
    public double tax(){
        return (energyCharge() + fixedCharge() + fuelSurcharge()) * taxSurchargePercentage ;
    }

    public double total(){
        return energyCharge() + fixedCharge() + fuelSurcharge() + tax();
    }

    public void changeFuelSurcharge(double fuelSurcharge){
        this.fuelSurchargePercentage = fuelSurcharge;
    }

}
