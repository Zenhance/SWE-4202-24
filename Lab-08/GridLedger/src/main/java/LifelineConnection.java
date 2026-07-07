public class LifelineConnection extends  ResidentialConnection{
    public static final double LIFELINE_REBATE=0.30;
    public LifelineConnection(Meter meter) {
        super(meter);
    }

    @Override
    double energyCharge() {
        return super.energyCharge()*(1-0.30);
    }

}
