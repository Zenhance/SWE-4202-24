import java.security.PublicKey;

public abstract class ParkingSlot {
    public static final ParkingSlot REGULAR=null;
    public static final ParkingSlot LARGE=null;
    public int MaxDay;
    public int hours;
    public abstract double Charge();
    public abstract double Surcharge();
}
