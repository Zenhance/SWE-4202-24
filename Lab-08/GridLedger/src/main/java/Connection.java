public abstract class Connection
{
    private static final double TAX_RATE = 0.05;

    private Meter meter;
    private double fuelPercentage = 0.10;

    public Connection(Meter meter)
    {
        this.meter = meter;
    }

    public abstract double energyCharge();
    public abstract double fixedCharge();

    public double fuelSurcharge()
    {
        return energyCharge()*fuelPercentage;
    }

    public double tax()
    {
        return (energyCharge()+fixedCharge()+fuelSurcharge())*TAX_RATE;
    }

    public double total()
    {
        double sum=energyCharge()+fixedCharge()+fuelSurcharge();
        return sum+tax();
    }

    public Meter getMeter()
    {
        return meter;
    }

    public double getFuelPercentage()
    {
        return fuelPercentage;
    }

    public void setFuelPercentage(double fuelPercentage)
    {
        this.fuelPercentage = fuelPercentage;
    }
}