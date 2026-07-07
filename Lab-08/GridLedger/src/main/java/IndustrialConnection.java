public class IndustrialConnection extends Connection{

    public IndustrialConnection(Meter meter) {
        super(meter);
    }
    public IndustrialConnection(Meter meter, double surChargePercent){
        super(meter, surChargePercent);
    }


    @Override
    public double energyCharge(){
        return 0.0d;
    }
    @Override
    public double fixedCharge(){
        return 0.0d;
    }

}
