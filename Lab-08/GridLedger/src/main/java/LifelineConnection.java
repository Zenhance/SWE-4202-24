public class LifelineConnection extends ResidentialConnection{
    private static final double REBATE_PERCENTAGE=0.30;

    public LifelineConnection(Meter meter){
        super(meter);
    }

    public double energyCharge(){
        double baseResidentialCharge=super.getEnergyCharge();
        return baseResidentialCharge*(1.0-REBATE_PERCENTAGE);
    }
}
