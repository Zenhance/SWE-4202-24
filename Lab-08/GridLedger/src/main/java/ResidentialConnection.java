public class ResidentialConnection extends Connection
{
    private static final double RES_FIXED = 100.0;
    private static final double RES_RATE_1 = 4.0;
    private static final double RES_RATE_2 = 7.0;
    private static final double RES_RATE_3 = 11.0;
    public ResidentialConnection (Meter meter)
    {super(meter);
    };
    public ResidentialConnection (Meter meter)
    {
        super(meter);
    }

@Override
public double energyCharge()
{

    int units = getMeter().getUnitsConsumed();
    if(units<=50)
    {
        return units.RES_RATE_1;
    }
     else if (units <= 200)
    {
        return 50*RES_RATE_1 + (units-50)*RES_RATE_2;

    }

    else {
        return 50*RES_RATE_1+150*RES_RATE_2+(units-200)*RES_RATE_3;
    }

}
@Override
public double fixedCharge()
{
    return RES_FIXED;
}





}