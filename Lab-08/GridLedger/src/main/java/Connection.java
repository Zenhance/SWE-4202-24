package main.java;

public abstract class Connection {
    private Meter meter;
    private static final double FUEL_DEFAULT=0.10;
    private static final double TAX_RATE=0.05;
    public Connection(Meter meter){
        this.meter=meter;
    }
    public abstract double energyCharge();
    public abstract double fixedCharge();
    public double fuelSurCharge(){
        return energyCharge()*FUEL_DEFAULT;
    }
    public double tax(){
        return (energyCharge()+fixedCharge()+fuelSurCharge())*TAX_RATE;
    }

}
