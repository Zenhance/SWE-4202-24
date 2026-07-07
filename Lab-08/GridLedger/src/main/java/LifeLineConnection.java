package main.java;

public class LifeLineConnection extends ResidentialConnection{
public static final double REBATE_RATE=0.30;
public LifeLineConnection(Meter meter){
    super(meter);
}

    @Override
    public double energyCharge() {
        return super.energyCharge()-(super.energyCharge()*REBATE_RATE);
    }

    @Override
    public double fixedCharge() {
        return super.fixedCharge();
    }
}
