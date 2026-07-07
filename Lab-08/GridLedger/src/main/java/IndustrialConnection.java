public class IndustrialConnection extends Connection{

    public IndustrialConnection(Meter meter){
        super(meter);
    }

    @Override
    public double fixedCharge() {
        return 500.0;
    }

    @Override
    public double energyCharge() {
        return meter.getUnitsConsumed()*10.0;
    }
}
