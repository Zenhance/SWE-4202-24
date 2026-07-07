public abstract class Connection {
    final double DEF_FUEL_PER=0.10;
    final double TAX_RATE=0.05;
    private final Meter meter;
    double fuelPer=DEF_FUEL_PER;

    public Connection(Meter meter) {
        this.meter = meter;
    }
    public int getUnitsConsumed() {
        return meter.getUnitsConsumed();
    }
}
