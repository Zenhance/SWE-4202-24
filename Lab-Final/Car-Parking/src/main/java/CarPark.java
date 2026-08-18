
import java.util.ArrayList;
import java.util.List;

public class CarPark{
    private int bikeFree;
    private int regularFree;
    private int largeFree;
    private int maxStay;
    private int earned;
    private int refused;

    private final List<ParkingRecord> parked = new ArrayList<>();

    public CarPark(int bikeSlots, int regularSlots, int largeSlots, int maxStay) {
        this.bikeFree = bikeSlots;
        this.regularFree = regularSlots;
        this.largeFree = largeSlots;
        this.maxStay = maxStay;
    }

    public void enter(Vehicle vehicle) throws NoNumberPlateException, NoSlotException {
        String plate = vehicle.getNumberPlate();
        if (plate == null || plate.isEmpty() || plate.equals("-")) {
            refused++;
            throw new NoNumberPlateException();
        }
        SlotType chosen = firstFreeSlot(vehicle);
        if (chosen == null) {
            refused++;
            throw new NoSlotException();
        }
        takeSlot(chosen);
        parked.add(new ParkingRecord(vehicle, chosen));
    }

    public void leave(String plate) throws NoVehivleFoundException {
        ParkingRecord record = findRecord(plate);
        if (record == null) {
            refused++;
            throw new NoVehivleFoundException();
        }
        earned += computeBill(record);
        removeRecord(record);
    }

    public void passTime(int hours) {
        List<ParkingRecord> evicted = new ArrayList<>();
        for (ParkingRecord record : parked) {
            record.hoursParked += hours;
            if (record.hoursParked >= maxStay) {
                evicted.add(record);
            }
        }
        for (ParkingRecord record : evicted) {
            earned += computeBill(record);
            removeRecord(record);
        }
    }

    public boolean contains(String plate) {
        return findRecord(plate) != null;
    }

    public int billOf(String plate) {
        return computeBill(findRecord(plate));
    }

    public SlotType slotOf(String plate) {
        return findRecord(plate).slot;
    }

    public int free(SlotType kind) {
        if (kind == SlotType.BIKE) {
            return bikeFree;
        }
        if (kind == SlotType.REGULAR) {
            return regularFree;
        }
        return largeFree;
    }

    public int count() {
        return parked.size();
    }

    public int earned() {
        return earned;
    }

    public int refused() {
        return refused;
    }

    private int computeBill(ParkingRecord record) {
        Vehicle vehicle = record.vehicle;
        SlotType slot = record.slot;
        int base = slot.priceFor(record.hoursParked);
        int surcharge = (slot != vehicle.homeSlot()) ? slot.getSurcharge() : 0;
        return vehicle.getDiscountScheme().apply(base + surcharge);
    }

    private ParkingRecord findRecord(String plate) {
        for (ParkingRecord record : parked) {
            if (record.vehicle.getNumberPlate().equals(plate)) {
                return record;
            }
        }
        return null;
    }

    private void removeRecord(ParkingRecord record) {
        parked.remove(record);
        freeSlot(record.slot);
    }

    private SlotType firstFreeSlot(Vehicle vehicle) {
        for (SlotType kind : vehicle.acceptanceOrder()) {
            if (free(kind) > 0) {
                return kind;
            }
        }
        return null;
    }

    private void takeSlot(SlotType kind) {
        if (kind == SlotType.BIKE) {
            bikeFree--;
        } else if (kind == SlotType.REGULAR) {
            regularFree--;
        } else {
            largeFree--;
        }
    }

    private void freeSlot(SlotType kind) {
        if (kind == SlotType.BIKE) {
            bikeFree++;
        } else if (kind == SlotType.REGULAR) {
            regularFree++;
        } else {
            largeFree++;
        }
    }

    private static class ParkingRecord {
        final Vehicle vehicle;
        final SlotType slot;
        int hoursParked;

        ParkingRecord(Vehicle vehicle, SlotType slot) {
            this.vehicle = vehicle;
            this.slot = slot;
            this.hoursParked = 0;
        }
    }
}
 
