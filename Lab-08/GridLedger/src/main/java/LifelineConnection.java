package main.java;

public class LifelineConnection extends ResidentialConnection{
    private static final double REBATE_RATE=0.30;

    public LifelineConnection(Meter meter){
        super(meter);
    }

    public double energyCharge(){
        double residentialEnergyCharge= super.energyCharge();
        return residentialEnergyCharge-residentialEnergyCharge*REBATE_RATE;
    }
}
