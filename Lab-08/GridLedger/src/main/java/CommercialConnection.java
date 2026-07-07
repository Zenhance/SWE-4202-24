public class CommercialConnection extends Connection {
    public CommercialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        int units = meter.getUnitsConsumed();
        if (units <= 100) {
            return units * 9.0;
        }
        return 100 * 9.0 + (units - 100) * 13.0;
    }

    @Override
    public double fixedCharge() {
        return 300;
    }
}
