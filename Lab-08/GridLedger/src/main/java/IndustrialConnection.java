public class IndustrialConnection extends Connection{
    public IndustrialConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge() {
        int units=getUnitsConsumed();
        return units*15;
    }

    @Override
    public double fixedCharge() {
        return 2000;
    }
}
