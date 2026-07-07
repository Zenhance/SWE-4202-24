public class CommercialConnection extends Connection {
    private static final double rate1=9.0;
    private static final double rate2=13.0;

    public CommercialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        int units=getUnits();
        if (units<=100) {
            return units*rate1;
        }
        return (100*rate1)+((units-100)*rate2);
    }

    @Override
    public double fixedCharge() {
        return 500.0;
    }
}
