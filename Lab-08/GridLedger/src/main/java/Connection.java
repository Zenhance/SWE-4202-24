public abstract class Connection {
    final double DEF_FUEL_PER=0.10;
    final double TAX_RATE=0.05;
    private final Meter meter;
    double fuelPercentage=DEF_FUEL_PER;

    public Connection(Meter meter) {
        this.meter = meter;
    }
    public int getUnitsConsumed() {
        return meter.getUnitsConsumed();
    }
    void setFuelPercentage(double fuelPercentage) {
        this.fuelPercentage = fuelPercentage;
    }

    public abstract double energyCharge();

    public abstract double fixedCharge();

    public double fuelSurcharge() {
        return energyCharge() * fuelPercentage;
    }
    public double tax() {
        double totalTax=(energyCharge() + fixedCharge() + fuelSurcharge()) * TAX_RATE;
        return totalTax;
    }
    public double total() {
        double total=energyCharge() + fixedCharge() + fuelSurcharge() + tax();
        return total;
    }
}
