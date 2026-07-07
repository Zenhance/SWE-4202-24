public class ResidentialConnection extends Connection {

    public ResidentialConnection(Meter meter){
        super(meter);
    }

    public double energyCharge(){
        return 0;
    }

    public double fixedCharge(){
        return 100;
    }

}
