import java.util.ArrayList;
import java.util.List;

public final class CarPark {
private final List<Slot> slots = new ArrayList<>();


    private int maximumStay;
    private int earned;
    private int refused;

    public CarPark(int bikeSlots, int regularSlots, int largeSlots
    ) {
        addSlots(SlotKind.BIKE, bikeSlots);
        addSlots(SlotKind.REGULAR, regularSlots);
        addSlots(SlotKind.LARGE, largeSlots);
    }

    private void addSlots(SlotKind kind, int count) {
        for (int i = 0; i < count; i++) {
            slots.add(new Slot(kind));
        }
    }

    public void setMaximumStay(int maximumStay) {
        this.maximumStay = maximumStay;
    }

    public void admit(Vehicle vehicle)
        throws ParkingException{
        if(vehicle.plate()==null||vehicle.plate().isBlank()||vehicle.plate().equals("-")){
            throw new MissingPlateException();
        }
            for(SlotKind acceptedKind:vehicle.acceptedSlots()){

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