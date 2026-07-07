public class CommercialConnection extends Connection{


    public CommercialConnection(Meter meter){
        super(meter);
    }


    @Override
    public double energyCharge(){

        int units=super.getMeter().getUnitsConsumed();

        double subtotal=0;

        if(units <= 100)

            subtotal += (units*9.0);

            else subtotal += (100*9.0 + (units-100) * 13.0);
            return subtotal; }


    @Override
    public double fixedCharge(){
        return 500.0;
    }
}