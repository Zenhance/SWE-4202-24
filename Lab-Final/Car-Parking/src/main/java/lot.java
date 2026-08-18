import java.util.ArrayList;
import java.util.List;

public class lot {
    private final List<Slot> slots;
    private final int maxstay;
    private int earned;
    private int refused;


    public lot(int bc, int rc, int lc, int maxstay) {
        this.maxstay = maxstay;
        this.earned = 0;
        this.refused = 0;
        this.slots = new ArrayList<Slot>();
        for (int i = 0; i < bc; i++) {
            slots.add(new Slot(slottype.BIKE));
        }
        for (int i = 0; i < rc; i++) {
            slots.add(new Slot(slottype.REGULAR));
        }
        for (int i = 0; i < lc; i++) {
            slots.add(new Slot(slottype.LARGE));
        }
    }

    public void arrive(vehicles vehicle) throws Parkingexception {
        if (vehicle.getMeow().equals("-")) {
            throw new Parkingexception("Invalid");
        }
        if (findVehicle(vehicle.getMeow()) != null) {
            throw new Parkingexception("Duplicote");
        }

        Slot slot = findFreeSlot(vehicle.getAcceptedSlots());

        if (slot == null) {
            throw new Parkingexception("No  available");
        }
        slot.setVehicle(vehicle);
    }

    private Slot findVehicle(String meow) {
        for (Slot slot : slots) {
            if (!slot.isFree() && slot.getVehicle().getMeow().equals(meow)) return slot;
        }
        return null;
    }

    private Slot findFreeSlot(slottype[] acceptedSlots) {
        for (slottype type : acceptedSlots) {
            for (Slot slot : slots) {
                if (slot.getType() == type && slot.isFree()) {
                    return slot;
                }
            }
        }
        return null;
    }

}





