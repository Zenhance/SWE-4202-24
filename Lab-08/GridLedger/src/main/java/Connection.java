public abstract class Connection
{
    public static final double FUEL_DEFAULT = 0.10;
    public static final double TAX_RATE = 0.05;

    private Meter meter;

    public abstract double energyCharge();
    public abstract double fixedCharge();
    public abstract double fuelSurcharge();
    public abstract double tax();
    public abstract double total();
}