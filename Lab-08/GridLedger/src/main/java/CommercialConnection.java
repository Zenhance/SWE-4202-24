public class CommercialConnection extends Connection{
    public CommercialConnection(Meter meter) {
        super(meter);
    }
    public CommercialConnection(Meter meter, double surChargePercent){
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
