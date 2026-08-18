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
            this.slots = new ArrayList<Slot>();
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
    public void arrive(Vehicle vehicle)
            throws ParkingException {
        if (vehicle.getPlate().equals("-")) {
            throw new ParkingException();
        }

        Slot slot = findFreeSlot(vehicle.getAcceptedSlots());
        if (slot == null) {
            throw new ParkingException();
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
}