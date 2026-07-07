public class LifelineConnection extends ResidentialConnection{
    private static final double REBATE=0.3;
    public LifelineConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        double residentialCharge=super.energyCharge();
        return residentialCharge-(residentialCharge*REBATE);
    }
}
