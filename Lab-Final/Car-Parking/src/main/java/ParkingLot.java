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

        /*
         * "-" means the plate was blank.
         */
        if (vehicle.getPlate().equals("-")) {
            throw new ParkingException();
        }

        Slot slot = findFreeSlot(vehicle.getAcceptedSlots());
        if (slot == null) {
            throw new ParkingException();
        }
        slot.setVehicle(vehicle);
    }
}