public class ResidentialConnection extends Connection{
    public ResidentialConnection(Meter meter) {
        super(meter);
    }
    public ResidentialConnection(Meter meter, double surChargePercent){
        super(meter, surChargePercent);
    }

    public double energyCharge(){
        return 0.0d;
    }

    public double fixedCharge(){
        return 0.0d;
    }
}
