import java.util.ArrayList;
import java.util.List;

public class CarParking {

    private final List<Slot> slots = new ArrayList<>();

    private int maximumStay;
    int earned;
    int refused;

    public CarParking(
            int bikeSlots,
            int regularSlots,
            int largeSlots
    ) {
        addSlots(SlotKind.BIKE, bikeSlots);
        addSlots(SlotKind.REGULAR, regularSlots);
        addSlots(SlotKind.LARGE, largeSlots);
    }

    private void addSlots(
            SlotKind kind,
            int count
    ) {
        for (int i = 0; i < count; i++) {
            slots.add(new Slot(kind));
        }
    }

    public void setMaximumStay(int maximumStay) {
        this.maximumStay = maximumStay;
    }

    public void admit(Vehicle vehicle)
            throws ParkingException {

        if (vehicle.plate() == null
                || vehicle.plate().isBlank()
                || vehicle.plate().equals("-")) {

            throw new MissingPlatesException();
        }

        for (SlotKind acceptedKind
                : vehicle.acceptedSlots()) {

            for (Slot slot : slots) {
                if (slot.kind() == acceptedKind
                        && slot.isFree()) {

                    slot.park(vehicle);
                    return;
                }
            }
        }

        throw new NoAvailableSlotException();
    }

    public void passTime(int hours) {
        for (Slot slot : slots) {
            if (!slot.isFree()) {
                slot.vehicle().addHours(hours);
            }
        }

        int removalHours =
                (maximumStay + 9) / 10;

        for (Slot slot : slots) {
            if (!slot.isFree()
                    && slot.vehicle().hours()
                    >= maximumStay) {

                int billedHours =
                        maximumStay + removalHours;

                earned += slot.bill(billedHours);
                slot.removeVehicle();
            }
        }
    }

    public void leave(String plate) {
        
    }


    public void recordRefusal() {
    }

}
