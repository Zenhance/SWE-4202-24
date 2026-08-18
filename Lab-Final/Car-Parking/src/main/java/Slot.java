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

    public void park(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}