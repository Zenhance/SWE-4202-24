import java.util.HashMap;
import java.util.Map;

public class CarPark {
    private int bikeCapacity, regularCapacity, largeCapacity;
    private int bikeOccupied, regularOccipied, largeOccupied;
    private int maxStay;
    private int earned;
    private int refused;
    private final Map<String, Vehicle> vehicles = new HashMap<>();

    public CarPark(int bikeCapacity, int regularCapacity, int largeCapacity, int bikeOccupied, int regularOccipied, int largeOccupied) {
        this.bikeCapacity = bikeCapacity;
        this.regularCapacity = regularCapacity;
        this.largeCapacity = largeCapacity;
        this.bikeOccupied = bikeOccupied;
        this.regularOccipied = regularOccipied;
        this.largeOccupied = largeOccupied;
    }

    public void setMaxStay(int hours){
        this.maxStay=maxStay;
    }
}
