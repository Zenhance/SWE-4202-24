public class ResidentialConnection extends Connection
{
    private static final double RES_RATE_1 = 4.0;
    private static final double RES_RATE_2 = 7.0;
    private static final double RES_RATE_3 = 11.0;
    private static final double RES_FIXED  = 100.0;

    private Meter meter;

    public ResidentialConnection(Meter meter)
    {
        super(meter);
    }

    @Override
    public double energyCharge()
    {
        int unit = meter.getUnitsConsumed();
        if(unit<=50)
        {
            return unit*RES_RATE_1;
        }
        else if(unit>=51 && unit<=200)
        {
            return 50*RES_RATE_1+(unit-50)*RES_RATE_2;
        }
        else
        {
            return 50*RES_RATE_1+150*RES_RATE_2+(unit-150)*RES_RATE_3;
        }
    }

    @Override
    public double fixedCharge()
    {
        return RES_FIXED;
    }
}