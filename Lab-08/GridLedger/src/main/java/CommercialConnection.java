public class CommercialConnection extends Connection {
    public CommercialConnection(Meter meter){
        super(meter);

    }
    @Override
    public double energyCharge(){
        int units=getMeter().getUnitsConsumed();
        if(units<=100){

        }

    }
    @Override
    public double fixedCharge(){
        return 500.0;
    }



}
