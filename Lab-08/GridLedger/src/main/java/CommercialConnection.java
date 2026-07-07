package main.java;

public class CommercialConnection extends Connection{
    private static final int FIRST_LIMIT=100;
    private static final double FIRST_RATE=9.0;
    private static final double SECOND_RATE=13.0;
    private static final double FIXED_CHARGE=250.0;

    public CommercialConnection(Meter meter){
        super(meter);
    }

    public double energyCharge(){
        int units=unitsConsumed();
        if(units<=FIRST_LIMIT){
            return units*FIRST_RATE;
        }
        return FIRST_LIMIT*FIRST_RATE+(units-FIRST_LIMIT)*SECOND_RATE;
    }

    public double fixedCharge(){
        return FIXED_CHARGE;
    }
}
