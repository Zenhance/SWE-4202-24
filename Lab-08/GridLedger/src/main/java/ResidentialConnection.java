public class ResidentialConnection extends Connection{
    private Meter meter;

    public ResidentialConnection(Meter meter){
        this.meter=meter;
    }

    public double energyCharge(){
        if(meter.getUnitsConsumed()<=50){
            return meter.getUnitsConsumed()*4.0;
        }
        else if(meter.getUnitsConsumed()>50 && meter.getUnitsConsumed()<=200){
            return 50*4.0 + (meter.getUnitsConsumed()-50)*7.0;
        }
        else{
            return 50*4.0 +150*7.0 + (meter.getUnitsConsumed()-200)*11.0;
        }
    }
}
