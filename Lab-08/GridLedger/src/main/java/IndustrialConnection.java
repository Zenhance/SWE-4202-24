package main.java;

import java.Meter;

public class IndustrialConnection extends Connection{
    private Meter meter;
    public IndustrialConnection(Meter  meter){
        super(meter);
    }
    public double energyCharge(){
        int units = unitConsumed();
        return units * 15.0;

    }
    public double fixedCharge(){
        return 2000.0;
    }
}
