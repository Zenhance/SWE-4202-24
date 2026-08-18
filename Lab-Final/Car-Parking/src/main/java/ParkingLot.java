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

    public int getBikeCapacity() {
        return bikeCapacity;
    }

    public void setBikeCapacity(int bikeCapacity) {
        this.bikeCapacity = bikeCapacity;
    }

    public int getRegularCapacity() {
        return regularCapacity;
    }

    public void setRegularCapacity(int regularCapacity) {
        this.regularCapacity = regularCapacity;
    }

    public int getLargeCapacity() {
        return largeCapacity;
    }

    public void setLargeCapacity(int largeCapacity) {
        this.largeCapacity = largeCapacity;
    }
}
