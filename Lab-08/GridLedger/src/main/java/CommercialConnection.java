public class CommercialConnection extends Connection {
    public CommercialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        int units = getUnits();
        if (units <= 100) {
            return units * 9.0;
        }
        return (100 * 9.0) + ((units - 100) * 13.0);
    }
}
