package main.java;

public abstract class Connection {
    private final Meter meter;
    private double fuelSurchargeRate;

    protected static final double DEFAULT_FUEL_SURCHARGE_RATE=0.0;
    protected static final double TAX_RATE=0.05;

    public Connection(Meter meter){
        if(meter==null){
            throw new IllegalArgumentException("Connection must have a meter");
        }

        this.meter=meter;
        this.fuelSurchargeRate=DEFAULT_FUEL_SURCHARGE_RATE;
    }
    public Connection(){
        meter=null;
    }

    public Meter meter(){
        return meter;
    }

    public int unitsConsumed(){
        return meter.unitsConsumed();
    }
    public abstract double energyCharge();

    public abstract double fixedCharge();

    public double fuelSurcharge(){
        return energyCharge() * fuelSurchargeRate;
    }

    public double tax(){
        return (energyCharge()+fixedCharge()+fuelSurcharge()) * TAX_RATE;
    }

    public double total(){
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();
    }

    public void setFuelSurchargeRate(double fuelSurchargeRate){
        if(fuelSurchargeRate<0){
            throw new IllegalArgumentException("Fuel surcharge rate cannot be negative.");
        }
        this.fuelSurchargeRate=fuelSurchargeRate;
    }

    public double getFuelSurchargeRate(){
        return fuelSurchargeRate;
    }
}
