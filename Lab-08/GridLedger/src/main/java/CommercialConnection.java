public class CommercialConnection {

    public CommercialConnection(Meter meter){
        super(meter);
    }

    public double energyCharge(){
        return 0;
    }

    public double fixedCharge(){
        return 500;
    }
}
