public class IndustrialConnection extends Connection {
    public IndustrialConnection(Meter meter){
        super(meter);

    }
    @Override
    public double energyCharge(){
        int units=getMeter().getUnitsConsumed();

    }

}
