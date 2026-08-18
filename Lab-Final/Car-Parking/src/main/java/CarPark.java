import java.util.ArrayList;
import java.util.List;

public class CarPark {
    private final int bikeSlots;
    private final int regularSlots;
    private final int largeSlots;
    private final List<Slot> slots = new ArrayList<>();

    public CarPark(int bikeSlots, int regularSlots, int largeSlots) {
        this.bikeSlots = bikeSlots;
        this.regularSlots = regularSlots;
        this.largeSlots = largeSlots;

        for (int i = 0; i < bikeSlots; i++) {
            slots.add(new Slot(SlotType.BIKE));
        }

        for (int i = 0; i < regularSlots; i++) {
            slots.add(new Slot(SlotType.REGULAR));
        }

        for (int i = 0; i < largeSlots; i++) {
            slots.add(new Slot(SlotType.LARGE));
        }
    }

    private Slot findFirstFreeSlot(Vehicle vehicle) {
        for (SlotType acceptedType : vehicle.getAcceptedSlotTypes()) {
            for (Slot slot : slots) {
                if (slot.isFree() && slot.getType() == acceptedType) {
                    return slot;
                }
            }
        }
        
        return null;
    }

    public Slot parkVehicle(Vehicle vehicle) {
        Slot slot = findFirstFreeSlot(vehicle);

        if (slot != null) {
            slot.park(vehicle);
        }

        return slot;
    }
}