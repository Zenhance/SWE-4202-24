import java.util.ArrayList;
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

    private Vehicle findVehicle(String plate) {
        for (Vehicle v : activeVehicles) {
            if (v.getPlate().equals(plate)) {
                return v;
            }
        }
        return null;
    }

    public void setupSlots(int bikeCount, int regCount, int largeCount){
        for (int i = 0; i < bikeCount; i++){
            bikeSlots.add(new Slot(SlotKind.BIKE, 10, 5, 0));
        }

        for (int i = 0; i < regCount; i++){
            regularSlots.add(new Slot(SlotKind.REGULAR, 30, 20, 15));
        }

        for (int i = 0; i < largeCount; i++){
            largeSlots.add(new Slot(SlotKind.LARGE, 50, 40, 25));
        }
    }

    public void setMaxStay(int maxStay) {
        this.maxStay = maxStay;
    }


    public void parkVehicle(Vehicle v) throws ParkRefusalException {
        if (v.getPlate() == null || v.getPlate().equals("-")) {
            throw new InvalidPlateException();
        }
        Slot selectedSlot = null;
        for (SlotKind kind : v.getPreferredSlots()) {
            List<Slot> pool = getSlotList(kind);
            if (!pool.isEmpty()) {
                selectedSlot = pool.remove(pool.size() - 1);
                break;
            }
        }

        if (selectedSlot == null) {
            throw new NoSlotAvailableException();
        }

        v.setAssignedSlot(selectedSlot);
        activeVehicles.add(v);
    }

    public void passTime(int hours) {
        List<Vehicle> evicted = new ArrayList<>();

        for (Vehicle v : activeVehicles) {
            v.addHours(hours);
            if (v.getHoursStood() >= maxStay) {
                evicted.add(v);
            }
        }

        for (Vehicle v : evicted) {
            activeVehicles.remove(v);
            totalEarned += v.calculateEvictionBill(maxStay);
            getSlotList(v.getAssignedSlot().getKind()).add(v.getAssignedSlot());
        }
    }





}
