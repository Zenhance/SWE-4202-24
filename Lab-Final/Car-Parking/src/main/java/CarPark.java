import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class CarPark {
    private int bikeCapacity, regularCapacity, largeCapacity;
    private int bikeOccupied, regularOccupied, largeOccupied;
    private int maxStay;
    private int earned;
    private int refused;
    private final Map<String, Vehicle> vehicles = new HashMap<>();

    public CarPark(int bikeCapacity, int regularCapacity, int largeCapacity, int bikeOccupied, int regularOccipied, int largeOccupied) {
        this.bikeCapacity = bikeCapacity;
        this.regularCapacity = regularCapacity;
        this.largeCapacity = largeCapacity;
        this.bikeOccupied = bikeOccupied;
        this.regularOccupied = regularOccipied;
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
        if (kind == SlotKind.REGULAR) return regularOccupied;
        return largeOccupied;
    }
    public void enter(Vehicle vehicle) throws ParkingException, {
        if (vehicle.plate.equals("")) {
            throw new NoPlateException();
        }
        for (SlotKind kind : vehicle.acceptOrder()) {
            if (occupiedOf(kind) < capacityOf(kind)) {
                changeOccupied(kind, 1);
                vehicle.slot = kind;
                vehicles.put(vehicle.plate, vehicle);
                return;
            }
            throw new NoSlotAvailableException();
        }

}
    public void leave(String plate) throws ParkingException {
        Vehicle vehicle = vehicles.get(plate);
        if (vehicle == null) {
            throw new UnknownPlateException();
        }
        int bill =computeBill(vehicle,Math.max(vehicle.hoursStood,1));
        earned+=bill;
        changeOccupied(vehicle.slot,-1);
        vehicles.remove(plate);
}

    private void changeOccupied(SlotKind kind, int delta){
        if(kind == SlotKind.BIKE){
            bikeOccupied+=delta;
        }
        else if(kind == SlotKind.REGULAR){
            regularOccupied+=delta;
        }
        else{
            largeOccupied+=delta;
        }
    }
    private int computeBill(Vehicle vehicle, int hours){
        SlotKind slot= vehicle.slot;
        int fee = slot.firstHour + (hours - 1) * slot.furtherHour;
        if (slot!=vehicle.ownKind()){
            fee+=slot.surcharge;
        }return vehicle.scheme.apply(fee);
    }

}

