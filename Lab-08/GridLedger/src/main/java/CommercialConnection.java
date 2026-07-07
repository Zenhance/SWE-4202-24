package main.java;

public class CommercialConnection extends Connection{
    public static final double Com_Rate_1=9.0;
    public static final double Com_Rate_2=13.0;
    public static final double Com_Fixed=500.0;
    public CommercialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge() {
        int unit= getMeter().getUnitConsumed();
        if(unit<=100){
            return Com_Rate_1;
        }
        else{
            return 100*Com_Rate_1+(unit-100)*Com_Rate_2;
        }
    }

    @Override
    public double fixedCharge() {
        return Com_Fixed;
    }
}
