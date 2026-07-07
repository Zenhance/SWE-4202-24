public class LifelineConnection extends ResidentialConnection{
    private static final double REBATE_PERCENTAGE=0.30;

    public LifelineConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge(){
        double baseResidentialCharge=super.energyCharge();
        return baseResidentialCharge*(1.0-REBATE_PERCENTAGE);
    }
}
