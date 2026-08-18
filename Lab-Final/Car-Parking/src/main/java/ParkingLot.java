import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class ParkingLot {
    private final List<Slot> slots;
    private int maxStay;
    private int earnings;
    private int refusedCount;

    public ParkingLot(int bikeSlots, int regularSlots, int largeSlots) {
        slots = new ArrayList<>();
    }

    public void setMaxStay(int hours) {
    }

    public int getMaxStay() {
        return 0;
    }

    public void admit(Vehicle vehicle) throws NoSlotAvailableException, BlankPlateException {
    }

    public int leave(String plate) throws UnknownPlateException {
        return 0;
    }

    public void passTime(int hours) {
    }

    public int getBill(String plate) throws UnknownPlateException {
        return 0;
    }

    public SlotKind getSlotKind(String plate) throws UnknownPlateException {
        return null;
    }

    public int getFreeCount(SlotKind kind) {
        return 0;
    }

    public int getVehicleCount() {
        return 0;
    }

    public int getEarned() {
        return earnings;
    }

    public int getRefused() {
        return refusedCount;
    }

    public void incrementRefused() {
    }
}
