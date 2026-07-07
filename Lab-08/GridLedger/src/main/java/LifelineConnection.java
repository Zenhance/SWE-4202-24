public class LifelineConnection extends ResidentialConnection
{
    private static final double LIFELINE_REBATE = 0.30;
    private static final double RES_FIXED  = 100.0;

    public LifelineConnection(Meter meter)
    {
        super(meter);
    }

    @Override
    public double energyCharge()
    {
        return super.energyCharge()-super.energyCharge()*LIFELINE_REBATE;
    }

    @Override
    public double fixedCharge()
    {
        return RES_FIXED;
    }
}