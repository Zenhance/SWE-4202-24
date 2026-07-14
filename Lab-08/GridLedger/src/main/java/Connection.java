public abstract class Connection {
    private static final double DEFAULT_FUEL_SURCHARGE=0.05;
    private static final double TAX=0.05;
    protected Meter meter;
    private double fuelSurcharge=DEFAULT_FUEL_SURCHARGE;
    protected double units;


    public Connection(Meter meter){

           this.meter=meter;
           units = meter.getUnitsConsumed();

    }
    public abstract double energyCharge();

    public abstract double fixedCharge();

    public double fuelSurcharge(){
        return energyCharge()*fuelSurcharge;
    }
    public double tax(){
        return (energyCharge()+fixedCharge()+fuelSurcharge())*TAX;
    }

    public double total(){
        return energyCharge()+fixedCharge()+tax();
    }

    public void setFuelSurcharge(double fuelSurcharge) {
        this.fuelSurcharge = fuelSurcharge;
    }
}
