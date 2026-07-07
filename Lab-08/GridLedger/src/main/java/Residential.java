public class Residential extends Connection{
    public Residential (Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge(){
        int units= meter.getUnitsConsumed();
        double charge=0;
if(units<=50){
charge = units * 4.0;
}








}
