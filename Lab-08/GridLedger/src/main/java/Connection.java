public abstract class Connection {
public static final double FUEL_DEFAULT=0.10;
public static final double TAX_RATE=0.05;

private final Meter meter;

public Connection(Meter meter){
    this.meter=meter;
}
public abstract double energyCharge();
public abstract double fixedCharge();

public double fuelSurcharge(){
    return energyCharge();
}
public double total(){
    return 1;
}
public
}
