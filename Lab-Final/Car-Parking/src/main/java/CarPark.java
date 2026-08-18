import java.util.ArrayList;
import java.util.List;

public final class CarPark {
    private final List<Slot> slots =
            new ArrayList<>();

    private int maximumStay;
    private int earned;
    private int refused;

    public CarPark(
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

            throw new MissingPlateException();
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

    public int bill(String plate)
            throws VehicleNotFoundException {

        Slot slot = findVehicle(plate);
        int hours = Math.max(
                1,
                slot.vehicle().hours()
        );

        return slot.bill(hours);
    }

    public SlotKind slotOf(String plate)
            throws VehicleNotFoundException {

        return findVehicle(plate).kind();
    }

    public void leave(String plate)
            throws VehicleNotFoundException {

        Slot slot = findVehicle(plate);
        int amount = bill(plate);

        earned += amount;
        slot.removeVehicle();
    }

    public int freeSlots(SlotKind kind) {
        int count = 0;

        for (Slot slot : slots) {
            if (slot.kind() == kind
                    && slot.isFree()) {

                count++;
            }
        }

        return count;
    }

    public int vehicleCount() {
        int count = 0;

        for (Slot slot : slots) {
            if (!slot.isFree()) {
                count++;
            }
        }

        return count;
    }

    public void passTime(int hours) {
        for (Slot slot : slots) {
            if (!slot.isFree()) {
                slot.vehicle().addHours(hours);
            }
        }
    }

    public int earned() {
        return earned;
    }

    public int refused() {
        return refused;
    }

    public void recordRefusal() {
        refused++;
    }

    private Slot findVehicle(String plate)
            throws VehicleNotFoundException {

        for (Slot slot : slots) {
            if (!slot.isFree()
                    && slot.vehicle()
                    .plate().equals(plate)) {

                return slot;
            }
        }

        throw new VehicleNotFoundException();
    }
}