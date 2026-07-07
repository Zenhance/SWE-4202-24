package main.java;

public class IndustrialConnection extends Connection{
    public static final double IND_RATE_1=15.0;
    public static final double IND_FIXED=2000.0;
    public IndustrialConnection(Meter meter){
        super(meter);
    }
    public double energyCharge(){
        int units= getMeter().getUnitConsumed();
        return units*IND_RATE_1;
    }

    @Override
    public double fixedCharge() {
        return IND_FIXED;
    }
}
