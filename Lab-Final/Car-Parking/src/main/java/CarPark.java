import java.util.ArrayList;
import java.util.List;


public class CarPark {

    private static final Departure DROVE_AWAY = new DriveAway();
    private static final Departure EVICTED = new Eviction();

    private final List<Slot> slots = new ArrayList<>();
    private final int maxStay;
    private int earnings = 0;

    public CarPark(int bikeSlots, int regularSlots, int largeSlots, int maxStay) {
        for (int i = 0; i < bikeSlots; i++) {
            slots.add(new BikeSlot());
        }
        for (int i = 0; i < regularSlots; i++) {
            slots.add(new RegularSlot());
        }
        for (int i = 0; i < largeSlots; i++) {
            slots.add(new LargeSlot());
        }
        this.maxStay = maxStay;
    }

    public void admit(Vehicle vehicle) throws NoSlotFreeException {
        for (String wanted : vehicle.slotPreference()) {
            for (Slot slot : slots) {
                if (slot.isFree() && slot.type().equals(wanted)) {
                    slot.take(vehicle);
                    return;
                }
            }
        }
        throw new NoSlotFreeException("no slot is free that " + vehicle.plate() + " can use");
    }

    public void passTime(int hours) {
        for (Slot slot : slots) {
            if (!slot.isFree()) {
                slot.occupant().standFor(hours);
                if (slot.occupant().hoursStood() >= maxStay) {
                    earnings = earnings + billUnder(slot, EVICTED);
                    slot.release();
                }
            }
        }
    }

    public int billOf(String plate) throws VehicleNotFoundException {
        return billUnder(slotHolding(plate), DROVE_AWAY);
    }

    public String slotOf(String plate) throws VehicleNotFoundException {
        return slotHolding(plate).type();
    }

    public int leave(String plate) throws VehicleNotFoundException {
        Slot slot = slotHolding(plate);
        int bill = billUnder(slot, DROVE_AWAY);
        slot.release();
        earnings = earnings + bill;
        return bill;
    }

    public int freeSlots(String type) {
        int free = 0;
        for (Slot slot : slots) {
            if (slot.isFree() && slot.type().equals(type)) {
                free = free + 1;
            }
        }
        return free;
    }

    public int earnings() {
        return earnings;
    }

    public int count() {
        int parked = 0;
        for (Slot slot : slots) {
            if (!slot.isFree()) {
                parked = parked + 1;
            }
        }
        return parked;
    }

    private int billUnder(Slot slot, Departure how) {
        return slot.billFor(how.hoursBilled(slot.occupant().hoursStood(), maxStay));
    }

    private Slot slotHolding(String plate) throws VehicleNotFoundException {
        for (Slot slot : slots) {
            if (!slot.isFree() && slot.occupant().plate().equals(plate)) {
                return slot;
            }
        }
        throw new VehicleNotFoundException("no vehicle with plate " + plate + " is in the park");
    }
}
