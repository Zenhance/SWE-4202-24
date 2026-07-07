public class IndustrialConnection extends Connection {
    final double RATE = 15.0;
    final double FIXED_CHARGE = 2000.0;
    public IndustrialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        return getUnitsConsumed() * RATE;
    }
}
