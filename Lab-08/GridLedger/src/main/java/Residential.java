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
else if(units<=200){
charge=50+4.0+(units-50)*7.0;
}
else{
charge=50*4.0+150*7.0+(units-200)*11.0;
}
return charge;
}
@Override
public double fixedCharge(){
return 100;
}
}