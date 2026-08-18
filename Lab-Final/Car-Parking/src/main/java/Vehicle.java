import java.util.List;

public abstract class Vehicle {
    private final String plate;

    protected Vehicle(String plate) {
        this.plate = plate;
    }

    public String getPlate() {
        return plate;
    }

    public abstract List<SlotType> getAcceptedSlotTypes();

    public SlotType getHomeSlotType() {
        return getAcceptedSlotTypes().get(0);
    }
}