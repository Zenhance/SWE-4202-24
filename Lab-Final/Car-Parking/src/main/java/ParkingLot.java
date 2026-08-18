import java.util.List;

public class ParkingLot {
    private final List<Slot> bikeSlots = new ArrayList<>();
    private final List<Slot> regularSlots = new ArrayList<>();
    private final List<Slot> largeSlots = new ArrayList<>();

    private final List<Vehicle> activeVehicles = new ArrayList<>();

    private int maxStay = 0;
    private int totalEarned = 0;
    private int totalRefused = 0;

    private List<Slot> getSlotList(SlotKind kind) {
        return switch (kind) {
            case BIKE -> bikeSlots;
            case REGULAR -> regularSlots;
            case LARGE -> largeSlots;
        };
    }

}
