public class CommercialConnection extends Connection {
    private double Rate_1 = 9.0;
    private double Rate_2 = 13.0;
    private double Rate_Fixed = 500.0;
    private Meter meter;

    public CommercialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double fixedCharge() {
        return Rate_Fixed;
    }

    public double energyCharge() {
        int units = meter.getUnitsConsumed();
        if(units <= 100) {
            return units*Rate_1;
        }
        return (100*Rate_1) + ((units-100)*Rate_2);

    }

}
