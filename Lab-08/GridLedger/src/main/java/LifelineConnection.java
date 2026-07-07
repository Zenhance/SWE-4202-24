public class LifelineConnection extends Connection{
    private static final double LIFELINE_REBATE = 0.30;

    public LifelineConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge(){
        return super.energyCharge()*(1.0-LIFELINE_REBATE);
    }
    }
