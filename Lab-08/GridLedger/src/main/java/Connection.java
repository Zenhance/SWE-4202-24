import java.security.PublicKey;

public abstract class Connection {
    protected Meter meter;
    private double fuelPercentage = 0.0;,

    public Connection(Meter meter) {
    if(meter==null){
        throw new IllegalArgumentException("Meter required");
    }
    this.meter=meter;

    }
    public abstract double energyCharge();
    public abstract double fixedCharge();
    public double fuelSurcharge(){
        return energyCharge()*fuelPercentage;
    }

}
