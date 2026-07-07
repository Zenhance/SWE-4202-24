public class ResidentialConnection extends Connection{

    private static final int BAND_1=50;
    private static final int BAND_2=200;
    private static final double RES_RATE_1 = 4.0;   // first 50 units
    private static final double RES_RATE_2 = 7.0;   // units 51..200
    private static final double RES_RATE_3 = 11.0;  // units above 200
    private static final double RES_FIXED  = 100.0;

    public ResidentialConnection(Meter meter) {
        super(meter);
    }

    @Override
    double energyCharge() {
        int units=getMeter().getUnitsConsumed();
        if(units<=BAND_1){
            return units*RES_RATE_1;
        }
        if(units<=BAND_2){
            return units*RES_RATE_1+(units-BAND_1)*RES_RATE_2;
        }
        return units*RES_RATE_1+(units-BAND_1)*RES_RATE_2+(units-BAND_2)*RES_RATE_3;

    }

    @Override
    double fixedCharge() {
        return RES_FIXED;
    }
}
