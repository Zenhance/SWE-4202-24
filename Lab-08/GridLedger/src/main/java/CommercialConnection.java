public class CommercialConnection extends Connection{
    private static final double COM_RATE_1 = 9.0;   // first 100 units
    private static final double COM_RATE_2 = 13.0;  // units above 100
    private static final double COM_FIXED  = 500.0;
    private static final int BAND_1=100;
    public CommercialConnection(Meter meter) {
        super(meter);
    }


    @Override
    double energyCharge() {
        int units = getMeter().getUnitsConsumed();
        if (units <= BAND_1) {
            return units * COM_RATE_1;
        }
            return units * COM_RATE_1 + (units - BAND_1) * COM_RATE_2;


    }

    @Override
    double fixedCharge() {
        return COM_FIXED;
    }

}
