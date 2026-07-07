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


}
