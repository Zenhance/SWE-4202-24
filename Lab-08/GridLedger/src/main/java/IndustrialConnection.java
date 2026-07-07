public class IndustrialConnection extends Connection{
    public IndustrialConnection(Meter meter){
        super(meter);
    }

    public double getFixedCharge(){
        return 500.0;
    }
    public double getEnergyCharge(){
        int units= getMeter().getUnitsConsumed();
        return units*15.0;
    }
}
