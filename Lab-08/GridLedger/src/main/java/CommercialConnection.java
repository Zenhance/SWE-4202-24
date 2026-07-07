public class CommercialConnection extends Connection {
    private static final double rate1 = 9.0;
    private static final double rate2 = 13.0;
    private static final double  FIXED_CHARGE_RATE = 500;

    public CommercialConnection(Meter meter) {
        super(meter);
    }


    public double energyCharge() {
        int units = meter.getUnitsConsumed();

        if(units <= 100){
            return units*rate1;
        }

            return 100*rate1 + (units-100)*rate2;

    }

    @Override
    public double fixedCharge() {
        return FIXED_CHARGE_RATE;
    }

}
