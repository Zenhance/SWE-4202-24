public class IndustrialConnection extends Connection {
    public IndustrialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        return getUnits() * 15.0;
    }

    @Override
    public double fixedCharge() {
        return 2000.0;
    }
}