package main.java;

import java.Meter;

public class LifelineConnection extends ResidentialConnection{
    private Meter meter;
    public LifelineConnection(Meter  meter){
        super(meter);
    }
    public double energyCharge(){
         double dis;
         double bill = super.energyCharge();
         dis = super.energyCharge()*.3;
         bill = bill = dis;
         return bill;
    }
}
