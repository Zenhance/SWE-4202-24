public abstract class Connection {
private double fuelPercentage=0.10;
private static final double TAX_RATE=0.05;

private final Meter meter;

public Connection(Meter meter){
    this.meter=meter;
}
public abstract double energyCharge();
public abstract double fixedCharge();

public double fuelSurcharge(){
    return energyCharge()*fuelPercentage;
}
public double total(){
    return 1;
}
public Meter getMeter(){
    return meter;
}
public double getFuelPercentage(){
    return fuelPercentage;
}
}
