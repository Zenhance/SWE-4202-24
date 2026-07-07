public class Residential extends Connection {
    public ResidentialConnection(Meter meter){
        super(meter);
    }
    public double fixedCharge(){
        return 20.0;
    }
    public Residential(){

    }
}
