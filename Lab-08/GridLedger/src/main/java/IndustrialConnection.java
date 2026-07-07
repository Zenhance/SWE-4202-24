package main.java;

public class IndustrialConnection extends Connection {
    private static final double RATE_PER_UNIT=15.0;
    private static final double FIXED_CHARGE=500.0;

    public IndustrialConnection(Meter meter){
        super(meter);
    }

    public double energyCharge(){
        return unitsConsumed()*RATE_PER_UNIT;
    }

    public double fixedCharge(){
        return FIXED_CHARGE;
    }
}
