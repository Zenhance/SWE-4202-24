import java.util.ArrayList;
import java.util.List;


class CarPark {
    private final List<Slot> allSlots = new ArrayList<>();
    private int maxStay = 0;
    private int runningTotalEarned = 0;
    private int refusalCount = 0;

    public void initializeSlots(int bikeCount, int regularCount, int largeCount) {
        for (int i = 0; i < bikeCount; i++) {
            allSlots.add(new Slot(SlotType.BIKE, 10, 5, 0));
        }
        for (int i = 0; i < regularCount; i++) {
            allSlots.add(new Slot(SlotType.REGULAR, 30, 20, 15));
        }
        for (int i = 0; i < largeCount; i++) {
            allSlots.add(new Slot(SlotType.LARGE, 50, 40, 25));
        }
    }

    public void setMaxStay(int maxStay) {
        this.maxStay = maxStay;
    }

    public void processArrival(VehicleType type, String plate, SchemeType scheme) throws ParkingRefusalException {
        if (plate.equals("-")) {
            throw new ParkingRefusalException("Blank plate entry error");
        }

        List<SlotType> preferences = switch (type) {
            case BIKE -> List.of(SlotType.BIKE, SlotType.REGULAR, SlotType.LARGE);
            case CAR -> List.of(SlotType.REGULAR, SlotType.LARGE);
            case TRUCK -> List.of(SlotType.LARGE);
        };

        Slot targetSlot = null;
        for (SlotType pref : preferences) {
            for (Slot slot : allSlots) {
                if (slot.getType() == pref && slot.isFree()) {
                    targetSlot = slot;
                    break;
                }
            }
            if (targetSlot != null) break;
        }

        if (targetSlot == null) {
            throw new ParkingRefusalException("No acceptable free slot found");
        }

        targetSlot.park(new Vehicle(plate, type, scheme));
    }

    public void passTime(int hours) {
        for (Slot slot : allSlots) {
            if (!slot.isFree()) {
                Vehicle v = slot.getCurrentVehicle();
                v.incrementHours(hours);

                if (v.getHoursStood() >= maxStay) {
                    int removalHours = (maxStay + 9) / 10;
                    int totalHoursToBill = maxStay + removalHours;
                    runningTotalEarned += slot.calculateBill(totalHoursToBill, v.getType(), v.getScheme());
                    slot.clear();
                }
            }
        }
    }

    public void processDeparture(String plate) throws ParkingRefusalException {
        Slot slot = findSlotByPlate(plate);
        Vehicle v = slot.getCurrentVehicle();

        int billableHours = Math.max(1, v.getHoursStood());
        runningTotalEarned += slot.calculateBill(billableHours, v.getType(), v.getScheme());
        slot.clear();
    }

    public String getBillEstimateForPlate(String plate) {
        try {
            Slot slot = findSlotByPlate(plate);
            Vehicle v = slot.getCurrentVehicle();
            int billableHours = Math.max(1, v.getHoursStood());
            return String.valueOf(slot.calculateBill(billableHours, v.getType(), v.getScheme()));
        } catch (ParkingRefusalException e) {
            return "NONE";
        }
    }

    public String getSlotTypeForPlate(String plate) {
        try {
            Slot slot = findSlotByPlate(plate);
            return slot.getType().name();
        } catch (ParkingRefusalException e) {
            return "NONE";
        }
    }

    public int getFreeSlotsCount(SlotType type) {
        int count = 0;
        for (Slot slot : allSlots) {
            if (slot.getType() == type && slot.isFree()) {
                count++;
            }
        }
        return count;
    }

    public int getActiveVehiclesCount() {
        int count = 0;
        for (Slot slot : allSlots) {
            if (!slot.isFree()) count++;
        }
        return count;
    }

    public int getRunningTotalEarned() { return runningTotalEarned; }
    public int getRefusalCount() { return refusalCount; }
    public void incrementRefusal() { refusalCount++; }

    private Slot findSlotByPlate(String plate) throws ParkingRefusalException {
        for (Slot slot : allSlots) {
            if (!slot.isFree() && slot.getCurrentVehicle().getPlate().equals(plate)) {
                return slot;
            }
        }
        throw new ParkingRefusalException("Plate not found within car park tracking boundary");
    }
}
