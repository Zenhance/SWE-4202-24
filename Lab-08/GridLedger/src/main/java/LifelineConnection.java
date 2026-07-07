public class LifelineConnection extends Connection{
    public LifelineConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        return 0;
    }

    @Override
    public double fixedCharge() {
        return 0;
    }
}
