public class IndustrialConnection extends Connection {
    private static final double rate = 15.0;
    private static final double FIXED_CHARGE_RATE = 2000;

    public IndustrialConnection(Meter meter) {
        super(meter);
    }

    public double energyCharge() {
        int units = meter.getUnitsConsumed();
        return units*rate;
    }

    @Override
    public double fixedCharge() {
        return FIXED_CHARGE_RATE;
    }
}
