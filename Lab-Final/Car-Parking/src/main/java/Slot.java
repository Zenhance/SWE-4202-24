public class Slot {
    private final SlotType type;
    private Vehicle vehicle;

    public Slot(SlotType type) {
        this.type = type;
    }

    public SlotType getType() {
        return type;
    }

    public boolean isFree() {
        return vehicle == null;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }
    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void remove() {
        this.vehicle = null;
    }

    public void removeVehicle() {

    }
}
