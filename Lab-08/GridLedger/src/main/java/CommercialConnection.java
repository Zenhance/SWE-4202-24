public class CommercialConnection extends Connection {
    final double BAND1_LIMIT = 100;
    final double RATE_BAND1 = 9.0;
    final double RATE_BAND2 = 13.0;
    final double FIXED_CHARGE = 500.0;

    public CommercialConnection(Meter meter) {
        super(meter);
    }
    @Override
    public double energyCharge() {
        int units = getUnitsConsumed();
        if (units <= BAND1_LIMIT) {
            return (units * RATE_BAND1);
        }else{
        return (BAND1_LIMIT * RATE_BAND1 + (units - BAND1_LIMIT) * RATE_BAND2);
        }
    }
}
