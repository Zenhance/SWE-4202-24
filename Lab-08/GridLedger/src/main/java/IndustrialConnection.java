public class IndustrialConnection extends Connection{

    public IndustrialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        int units = super.getMeter().getUnitsConsumed();
        double subtotal = units * 15.0;
        return subtotal;
    }

    @Override
    public double fixedCharge() {
        return 2000.0;
    }
}
