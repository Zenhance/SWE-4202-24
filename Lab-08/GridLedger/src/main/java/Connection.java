import java.util.Collections;


public abstract class Connection {
    private Meter meter;
    private double fuelPercent = 0.10;
    private static final double TAX_RATE = 0.05;
    public static int total=0;

    public Connection(Meter meter) {
        this.meter=meter;
    }

    public double fuelSurcharge() {
        return energyCharge()*fuelPercent;
    }

    public abstract double energyCharge();
    public abstract double fixedCharge();
    public double tax() {
        return (energyCharge()+fixedCharge()+fuelSurcharge())*TAX_RATE;
    }
    public double total() {
        return energyCharge()+fixedCharge()+fuelSurcharge()+tax();
    }
}
