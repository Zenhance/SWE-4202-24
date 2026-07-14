public class CommercialConnection extends Connection{
    public CommercialConnection(Meter meter){
        super(meter);
    }
    @Override
    public double energyCharge() {
        double c = 0;
        if(units<100){
            c =  100*9.0;
        }

        else  c = 100*9.0 +(units-100)*13.0;
        return c;
    }

    @Override
    public double fixedCharge() {
        return 150.0;
    }
}
