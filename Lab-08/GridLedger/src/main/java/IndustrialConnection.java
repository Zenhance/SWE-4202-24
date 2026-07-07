public class IndustrialConnection extends Connection {
    public IndustrialConnection(Meter meter){
        super(meter);
    }

    public double energyCharge(){
        return 0.0;
    }

    public double  fixedCharge(){
        return 0.0;
    }
}
