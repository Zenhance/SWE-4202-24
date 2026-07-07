package main.java;

public class LifeLineConnection extends ResidentialConnection{
    public static final double LifeLine_Rebate=0.30;
    public static final double Res_Fixed=100.0;
    public LifeLineConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge() {
        return super.energyCharge()-super.energyCharge()*LifeLine_Rebate;
    }

    @Override
    public double fixedCharge() {
        return Res_Fixed;
    }
}
