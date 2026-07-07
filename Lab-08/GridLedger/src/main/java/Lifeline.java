public class Lifeline extends Residential {
    private double rebate=0.30;

    public Lifeline(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge(){
        return super.energyCharge()
        (super.energyCharge()*rebate);
    }

}
