public class LifelineConnection extends ResidentialConnection{
    private double Rebate = 0.3;
    private Meter meter;

    public LifelineConnection(Meter meter) {
        super(meter);
    }


    @Override
    public double energyCharge() {
        return super.energyCharge() * (1.0 - Rebate);
    }
}
