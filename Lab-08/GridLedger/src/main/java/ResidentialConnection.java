public class ResidentialConnection extends Connection {
    final double BAND1_LIMIT = 50;
    final double BAND2_LIMIT = 200;
    final double RATE_BAND1 = 4.0;
    final double RATE_BAND2 = 7.0;
    final double RATE_BAND3 = 11.0;
    final double FIXED_CHARGE = 100.0

    public ResidentialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        int units = getUnitsConsumed();
        if (units <= BAND1_LIMIT) {
            return (units * RATE_BAND1);
        }else if (units <= BAND2_LIMIT) {
            return (BAND1_LIMIT * RATE_BAND1 + (units - BAND1_LIMIT) * RATE_BAND2);
        } else {
            return (BAND1_LIMIT * RATE_BAND1
                    + (BAND2_LIMIT - BAND1_LIMIT) * RATE_BAND2
                    + (units - BAND2_LIMIT) * RATE_BAND3);
        }
    }

}
