public class LifelineConnection extends ResidentialConnection {
    final double REBATE_PERCENTAGE = 0.30;
    public LifelineConnection(Meter meter) {
        super(meter);
    }
    @Override
    public double energyCharge() {
        double residentialCharge = super.energyCharge();
        return residentialCharge - (residentialCharge * REBATE_PERCENTAGE);
    }
}
