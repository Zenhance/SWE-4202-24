public abstract class Connection
{

    public static final double DEFAULT_FUEL_SURCHARGE_PERCENTAGE = 0.10;
    public static final double TAX_PERCENTAGE = 0.05;
    private final Meter meter;
    private double fuelSurchargePercentage;
    protected Connection(Meter meter)
    {
        this(meter,DEFAULT_FUEL_SURCHARGE_PERCENTAGE);
    }
    protected Connection(Meter meter, double fuelSurchargePercentage)
    {
        if(meter == null)
        {
            throw new IllegalArgumentException("A connection must have a meter.");
        }
        this.meter = meter;
        this.fuelSurchargePercentage = fuelSurchargePercentage;
    }
    public void setFuelSurchargePercentage(double fuelSurchargePercentage)
    {
        this.fuelSurchargePercentage = fuelSurchargePercentage;
    }
    public int getUnitsConsumed()
    {
        return meter.getUnitsConsumed();
    }
    public abstract double energyCharge();
    public abstract double fixedCharge();
}