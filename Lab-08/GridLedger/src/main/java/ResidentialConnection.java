public class ResidentialConnection extends Connection{

    public ResidentialConnection(Meter meter){
        super(meter);
    }



    @Override
    public double energyCharge(){
        int units=super.getMeter().getUnitsConsumed();

        double subtotal=0;


    }


    @Override
    public double fixedCharge(){



    }












}