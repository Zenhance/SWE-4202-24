public class LifelineConnection extends Connection{

    public LifelineConnection(Meter meter){
        super(meter);
    }


    @Override
    public double energyCharge(){
        double rebate=super.energyCharge()*0.30;
        return super.energyCharge()-rebate;


    }










}