import java.util.ArrayList;
import java.util.EnumMap;
import java.util.List;
import java.util.Map;

public class SlotManager {

    private final Map<SlotType, List<ParkingSlot>> slots;

    public SlotManager() {

        slots = new EnumMap<>(SlotType.class);

        for (SlotType type : SlotType.values()) {
            slots.put(type, new ArrayList<>());
        }
    }

    public void initialize(int bikeCount,
                           int regularCount,
                           int largeCount) {

        addSlots(SlotType.BIKE, bikeCount);
        addSlots(SlotType.REGULAR, regularCount);
        addSlots(SlotType.LARGE, largeCount);
    }

    private void addSlots(SlotType type, int count) {

        for (int i = 0; i < count; i++) {
            slots.get(type).add(new ParkingSlot(type));
        }
    }

    public ParkingSlot findSlot(Vehicle vehicle) {

        for (SlotType type : vehicle.getPreferredSlotTypes()) {

            ParkingSlot slot = findFreeSlot(type);

            if (slot != null) {
                return slot;
            }
        }

        return null;
    }

    private ParkingSlot findFreeSlot(SlotType type) {

        for (ParkingSlot slot : slots.get(type)) {

            if (slot.isFree()) {
                return slot;
            }
        }

        return null;
    }

    public void park(Vehicle vehicle, ParkingSlot slot) {
        slot.park(vehicle);
    }

    public void free(ParkingSlot slot) {
        slot.free();
    }

    public int freeCount(SlotType type) {

        int count = 0;

        for (ParkingSlot slot : slots.get(type)) {

            if (slot.isFree()) {
                count++;
            }
        }

        return count;
    }
}