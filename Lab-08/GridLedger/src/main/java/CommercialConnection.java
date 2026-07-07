package main.java;

import java.Meter;

public class CommercialConnection extends Connection{
    private Meter meter;
    public CommercialConnection(Meter  meter){
        super(meter);
    }
    public double energyCharge(){
        int units = unitConsumed();
        double c = 0;
        if (units <= 100) {
            c += units * 9.0;
        } else {
            c += 100 * 9.0;
            c += (units - 100) * 13.0;
        }
        return c;
    }
    public double fixedCharge(){
        return 500.0;
    }
}
