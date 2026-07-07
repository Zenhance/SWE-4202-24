import java.util.Collections;

public abstract class Connection {
    public static int total=0;
    public  Byte energyCharge() {
        return 0;
    }


    public double fixedCharge() {
        return 0;
    }

    public double fuelSurcharge() {
        return 0;
    }

    public double tax() {return 0;
    }

    public double total() {
        return total;
    }
}
