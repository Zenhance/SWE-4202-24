import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLot {
    private final List<Slot> slots;
    private final Map<String, Slot> plateToSlot;
    private int maxStay;
    private int earnings;
    private int refusedCount;

    public ParkingLot(int bikeSlots, int regularSlots, int largeSlots) {
        slots = new ArrayList<>();
        plateToSlot = new HashMap<>();
        for (int i = 0; i < bikeSlots; i++) {
            slots.add(new Slot(SlotKind.BIKE));
        }
        for (int i = 0; i < regularSlots; i++) {
            slots.add(new Slot(SlotKind.REGULAR));
        }
        for (int i = 0; i < largeSlots; i++) {
            slots.add(new Slot(SlotKind.LARGE));
        }
    }

    public void setMaxStay(int hours) {
        this.maxStay = hours;
    }

    public int getMaxStay() {
        return maxStay;
    }

    public void admit(Vehicle vehicle) throws NoSlotAvailableException {
        for (SlotKind preferred : vehicle.acceptableSlotKinds()) {
            for (Slot slot : slots) {
                if (slot.isFree() && slot.getKind() == preferred) {
                    slot.setParkedVehicle(vehicle);
                    plateToSlot.put(vehicle.getPlate(), slot);
                    return;
                }
            }
        }
        throw new NoSlotAvailableException();
    }

    public int leave(String plate) throws UnknownPlateException {
        Slot slot = plateToSlot.remove(plate);
        if (slot == null) {
            throw new UnknownPlateException();
        }
        int bill = slot.getParkedVehicle().calculateBill(slot);
        earnings += bill;
        slot.setParkedVehicle(null);
        return bill;
    }

    public void passTime(int hours) {
        List<String> platesToEvict = new ArrayList<>();
        for (Slot slot : slots) {
            if (!slot.isFree()) {
                Vehicle vehicle = slot.getParkedVehicle();
                vehicle.addHours(hours);
                if (vehicle.getHoursStood() >= maxStay) {
                    platesToEvict.add(vehicle.getPlate());
                }
            }
        }
        for (String plate : platesToEvict) {
            Slot slot = plateToSlot.remove(plate);
            if (slot != null) {
                int removalHours = (maxStay + 9) / 10;
                int bill = slot.getParkedVehicle().calculateBillForHours(slot, maxStay + removalHours);
                earnings += bill;
                slot.setParkedVehicle(null);
            }
        }
    }

    public int getBill(String plate) throws UnknownPlateException {
        Slot slot = plateToSlot.get(plate);
        if (slot == null) {
            throw new UnknownPlateException();
        }
        return slot.getParkedVehicle().calculateBill(slot);
    }

    public SlotKind getSlotKind(String plate) throws UnknownPlateException {
        Slot slot = plateToSlot.get(plate);
        if (slot == null) {
            throw new UnknownPlateException();
        }
        return slot.getKind();
    }

    public int getFreeCount(SlotKind kind) {
        int count = 0;
        for (Slot slot : slots) {
            if (slot.isFree() && slot.getKind() == kind) {
                count++;
            }
        }
        return count;
    }

    public int getVehicleCount() {
        return plateToSlot.size();
    }

    public int getEarned() {
        return earnings;
    }

    public int getRefused() {
        return refusedCount;
    }

    public void incrementRefused() {
        refusedCount++;
    }
}
