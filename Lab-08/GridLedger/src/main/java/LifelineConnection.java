public class LifelineConnection extends ResidentialConnection{
    private static final double LIFELINE_REBATE = 0.30;
    public LifelineConnection(Meter meter){
        super(meter);
    }

    @Override
    public double energyCharge() {
        return super.energyCharge()*(1-LIFELINE_REBATE);
    }
}
