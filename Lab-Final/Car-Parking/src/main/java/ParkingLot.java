import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Vehicle> bikeSlots = new ArrayList<>();
    List<Vehicle> regularSlots = new ArrayList<>();
    List<Vehicle> largeSlots = new ArrayList<>();
    private int maxHours;
    private int bikeCapacity;
    private int regularCapacity;
    private int largeCapacity;
    public ParkingLot(int bikeCapacity, int regularCapacity, int largeCapacity) {
        this.bikeCapacity = bikeCapacity;
        this.regularCapacity = regularCapacity;
        this.largeCapacity = largeCapacity;
    }
    public int getMaxHours() {
        return maxHours;
    }
    public void setMaxHours(int maxHours) {
        this.maxHours = maxHours;
    }
}
