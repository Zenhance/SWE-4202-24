package Parking;
public class ParkingSlot{
    private final String kind;
    private Vehicle vehicle;
    public ParkingSlot(String kind) {
        this.kind = kind;
        this.vehicle = null;
    }
    public String getKind() {
        return kind;
    }
    public Vehicle getVehicle() {
        return vehicle;
    }
    public boolean isFree() {
        return vehicle == null;
    }
    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
        vehicle.setSlot(this);
    }
    public void leave() {
        if (vehicle != null) {
            vehicle.setSlot(null);
            vehicle = null;
        }
    }
}