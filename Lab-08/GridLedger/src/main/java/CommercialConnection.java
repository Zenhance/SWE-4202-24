public class CommercialConnection extends Connection{
    public CommercialConnection(Meter meter){
        super(meter);
    }
    public double getFixedCharge(){
        return 120.0;
    }

    public double getEnergyCharge(){
        int units= getMeter().getUnitsConsumed();
        double charge=0;
        if(units<=100){
            charge+=units*9.0;
        }
        else{
            charge+=(100*9.0)+((units-100)*13.0):
        }
        return charge;
    }
}
