package main.java;

public class CommercialConnection extends Connection{
    public static final double COM_RATE_1=9.0;
    public static final double COM_RATE_2=13.0;
    public static final double COM_FIXED=500.0;
    public CommercialConnection(Meter meter){
        super(meter);
    }
    public double energyCharge(){
        int units= getMeter().getUnitConsumed();
        if(units<=100){
            return units*COM_RATE_1;
        }
        else{
            return 100*COM_RATE_1+(units-100)*COM_RATE_2;
        }
    }

    @Override
    public double fixedCharge() {
        return COM_FIXED;
    }
}
