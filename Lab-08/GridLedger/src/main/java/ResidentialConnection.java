public class ResidentialConnection extends Connection{
    public ResidentialConnection(Meter meter){
        super(meter);
    }

    @Override
     public double getFixedCharge(){
        return 40.0;
     }

     @Override
     public double getEnergyCharge(){
        int units= getMeter().getUnitsConsumed();
        double charge=0;
        if(units<=50){
            charge+=units*4.0;
        }
        if(units<=200){
            charge+=(50*4.0)+((units-50)*7.00);
        }
        else{
            charge+=(50*4.0)+(150*7.0)+((units-200)*11.0);
        }
        return charge;
     }
}
