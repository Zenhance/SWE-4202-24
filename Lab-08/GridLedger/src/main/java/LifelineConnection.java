public class LifelineConnection extends ResidentialConnection{

    public LifelineConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        double rebate = super.energyCharge() * .30;
        return super.energyCharge() - rebate;
    }
}
