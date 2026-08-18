public class ResidentialConnection extends Connection {
    private static final double rate1 = 4.0;
    private static final double rate2 = 7.0;
    private static final double rate3 = 11.0;
    private static final double FIXED_CHARGE_RATE = 100;
    public ResidentialConnection(Meter meter) {
        super(meter);
    }

    public double energyCharge() {
        int units = meter.getUnitsConsumed();

                if(units <= 50){
                    return units*rate1;
                }
                if(units <= 200){
                    return 50*rate1 + (units-50)*rate2;
                }

                    return 50*rate1 + 200*rate2 + (units-50-200)*rate3;


    }
    @Override
    public double fixedCharge() {
        return FIXED_CHARGE_RATE;
    }
}
