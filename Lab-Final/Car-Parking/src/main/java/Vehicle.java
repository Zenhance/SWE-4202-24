import java.util.List;

public abstract class Vehicle {
    public abstract List<SlotType> getAcceptedSlotTypes();

    public SlotType getHomeSlotType() {
        return getAcceptedSlotTypes().get(0);
    }
}