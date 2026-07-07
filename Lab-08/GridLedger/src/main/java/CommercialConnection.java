public class CommercialConnection extends Connection{ 
    
    public CommercialConnection(Meter meter) {
        super(meter);
    }

    @Override
    public double energyCharge() {
        return 0;
    }
}
