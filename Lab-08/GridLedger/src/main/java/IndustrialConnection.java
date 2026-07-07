package main.java;

public class IndustrialConnection extends Connection{
    public static final double Ind_Rate=15.0;
    public static final double Ind_Fixed=2000.0;
    public IndustrialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge() {
        int unit= getMeter().getUnitConsumed();
        return unit*Ind_Rate;
    }

    @Override
    public double fixedCharge() {
        return Ind_Fixed;
    }
}
