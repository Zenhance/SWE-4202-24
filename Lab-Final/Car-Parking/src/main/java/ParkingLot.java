import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
        private final List<Slot> slots;
        private final int maxStay;
        private int earned;
        private int refused;

        public ParkingLot(int bikeCount, int regularCount, int largeCount, int maxStay) {
            this.maxStay = maxStay;
            this.earned = 0;
            this.refused = 0;
            this.slots = new ArrayList<>();
            for (int i = 0; i < bikeCount; i++) {
                slots.add(new Slot(SlotType.BIKE));
            }
            for (int i = 0; i < regularCount; i++) {
                slots.add(new Slot(SlotType.REGULAR));
            }
            for (int i = 0; i < largeCount; i++) {
                slots.add(new Slot(SlotType.LARGE));
            }
        }

    public void arrive(Vehicle vehicle) throws ParkingException {
        if (vehicle.getPlate().equals("-")) {
            throw new ParkingException("Invalid license plate");
        }
        if (findVehicle(vehicle.getPlate()) != null) {
            throw new ParkingException("Duplicate license plate");
        }

        Slot slot = findFreeSlot(vehicle.getAcceptedSlots());

        if (slot == null) {
            throw new ParkingException("No suitable slot available");
        }
        slot.setVehicle(vehicle);
    }
    private Slot findFreeSlot(SlotType[] acceptedSlots) {
        for (SlotType type : acceptedSlots) {
            for (Slot slot : slots) {
                if (slot.getType() == type && slot.isFree()) {
                    return slot;
                }
            }
        }
        return null;
    }
    public void passTime(int hours) {
        for (Slot slot : slots) {
            if (!slot.isFree()) slot.getVehicle().addHours(hours);
        }
        for (Slot slot : slots) {
            if (!slot.isFree() && slot.getVehicle().getHours() >= maxStay) {
                evict(slot);
            }
        }
    }
    private void evict(Slot slot) {
            Vehicle vehicle = slot.getVehicle();
            int removalHours = (maxStay + 9)/10;
            int billHours = maxStay + removalHours;
        int bill = calculateBill(vehicle, slot, billHours);
        earned += bill;
        slot.removeVehicle();
    }
    public String bill(String plate) throws ParkingException {
            Slot slot = findVehicle(plate);
            if (slot == null) {
            throw new ParkingException("Invalid.");
        }
            Vehicle vehicle = slot.getVehicle();
            int hours = Math.max(1, vehicle.getHours());
            return String.valueOf(calculateBill(vehicle, slot, hours));
    }
    private Slot findVehicle(String plate) {
            for (Slot slot : slots) {
                if (!slot.isFree() && slot.getVehicle().getPlate().equals(plate)) return slot;
        }
        return null;
    }

    private int calculateBill(Vehicle vehicle, Slot slot, int hours) {
            SlotType slotType = slot.getType();
        int bill = slotType.getFirstHour() + (hours - 1) * slotType.getFurtherHour();
        if (slotType != vehicle.getAcceptedSlots()[0]) {
            bill += slotType.getSurcharge();
        }
        bill = vehicle.applyDiscount(bill);
        return Math.max(0, bill);
    }
    public String slot(String plate) throws ParkingException {
            Slot slot = findVehicle(plate);
            if (slot == null) throw new ParkingException("Invalid");
            return slot.getType().name();
    }
    public int free(String kind) {
            SlotType type = SlotType.valueOf(kind);
            int count = 0;
            for (Slot slot : slots) {
                if (slot.getType() == type && slot.isFree()) {
                    count++;
            }
        }
        return count;
    }
    public int count() {
        int count = 0;
        for (Slot slot : slots) {
            if (!slot.isFree()) {
                count++;
            }
        }
        return count;
    }
    public int getEarned() {
        return earned;
    }

    public int getRefused() {
        return refused;
    }

    public void addRefusal() {
        refused++;
    }

    public void leave(String plate) throws ParkingException {
        Slot slot = findVehicle(plate);
        if (slot == null) {
            throw new ParkingException("Vehicle not found");
        }
        Vehicle vehicle = slot.getVehicle();
        int hours = Math.max(1, vehicle.getHours());
        int bill = calculateBill(vehicle, slot, hours);
        earned += bill;
        slot.removeVehicle();
    }
}