public class ResidentialConnection extends Connection {
    private static final double rate1=4.0;
    private static final double rate2=7.0;
    private static final double rate3=11.0;

    public ResidentialConnection(Meter meter) {

            super(meter);

    }
    @Override
    public double energyCharge() {
        return (50*rate1)+(150*rate2)+((getUnits()-200)*rate3);
    }
    @Override
    public double fixedCharge() {
        return 100.0;
    }
}
