public class LifelineConnection extends ResidentialConnection{
    public LifelineConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge(){
        double residentialCharge = super.energyCharge();
        return residentialCharge - (residentialCharge * 0.30);}
}
