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
    public void countRefusal(){
        refused++;
    }
    public int capacityOf(SlotKind kind){
        if (kind == SlotKind.BIKE) return bikeCapacity;
        if (kind == SlotKind.REGULAR) return regularCapacity;
        return largeCapacity;
    }
    public int occupiedOf(SlotKind kind){
        if (kind == SlotKind.BIKE) return bikeOccupied;
        if (kind == SlotKind.REGULAR) return regularOccipied;
        return largeOccupied;
    }
}
