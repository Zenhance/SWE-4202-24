public class CommercialConnection extends Connection {

    public CommercialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double fixedCharge() {
        return 500.0;
    }

    @Override
    public double energyCharge() {
        int units = meter.getUnitsConsumed();
        double c = 0;

        if (units <= 100) {
            c += units * 9.0;
        } else {
            c += 100 * 9.0;
            c += (units - 100) * 13.0;
        }
        return c;
    }
}