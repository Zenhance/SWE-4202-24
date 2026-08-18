import java.util.ArrayList;

public class ParkingLot {
    ArrayList<Slot> slots = new ArrayList<Slot>();
    ArrayList<Vehicle> vehicles = new ArrayList<Vehicle>();

    int maxStay;
    int earned;
    int refused;

    public ParkingLot(int bike, int regular, int large) {
        earned = 0;
        refused = 0;

        for (int i = 0; i < bike; i++) {
            slots.add(new Slot(SlotType.BIKE));
        }

        for (int i = 0; i < regular; i++) {
            slots.add(new Slot(SlotType.REGULAR));
        }

        for (int i = 0; i < large; i++) {
            slots.add(new Slot(SlotType.LARGE));
        }
    }

    public void setMaxStay(int x) {
        maxStay = x;
    }

    public Vehicle findVehicle(String plate) {
        for (int i = 0; i < vehicles.size(); i++) {
            if (vehicles.get(i).plate.equals(plate)) {
                return vehicles.get(i);
            }
        }
        return null;
    }

    public void enter(Vehicle v) throws RefusalException {
        if (v.plate.equals("-") || v.plate.length() == 0) {
            throw new NoPlateException();
        }
        Slot chosen = null;
        SlotType[] wanted = v.getWantedSlots();

        for (int i = 0; i < wanted.length; i++) {
            for (int j = 0; j < slots.size(); j++) {
                Slot s = slots.get(j);

                if (s.type == wanted[i] && s.isFree()) {
                    chosen = s;
                    break;
                }
            }
        }
        if (chosen == null) {
            throw new NoSlotException();
        }
        chosen.vehicle = v;
        v.slot = chosen;

        vehicles.add(v);
    }

    public int getFirstRate(SlotType type) {
        if (type == SlotType.BIKE) {
            return 10;
        } else if (type == SlotType.REGULAR) {
            return 30;
        } else {
            return 30;
        }
    }

    public int getFurthrRate(SlotType type) {
        if (type == SlotType.BIKE) {
            return 5;
        } else if (type == SlotType.REGULAR) {
            return 20;
        } else {
            return 40;
        }
    }

    public int getSurcharge(SlotType type) {
        if (type == SlotType.BIKE) {
            return 0;
        } else if (type == SlotType.REGULAR) {
            return 15;
        } else {
            return 25;
        }
    }

    public int calculateBill(Vehicle v, boolean eviction) {
        SlotType type = v.slot.type;
        int h = v.hours;

        if (eviction) {
            h = maxStay;
        }

        int bill = getFirstRate(type);
        if (h > 1) {
            bill = bill + (h - 1) * getFurthrRate(type);
        }

        SlotType ownType = v.getWantedSlots()[0];
        if (type != ownType) {
            bill = bill + getSurcharge(type);
        }
        if (eviction) {
            int removalHours = maxStay / 10;
            if (maxStay % 10 != 0) {
                removalHours++;
            }
            bill = bill + removalHours * getFurthrRate(type);
        }
        bill = v.discount.getDiscountedBill(bill);
        return bill;
    }

    public int bill(String plate) throws NotFoundException {
        Vehicle v = findVehicle(plate);
        if (v == null) {
            throw new NotFoundException();
        }
        return calculateBill(v, false);
    }

    public String getSlot(String plate) throws NotFoundException {
        Vehicle v = findVehicle(plate);
        if (v == null) {
            throw new NotFoundException();
        }
        return v.slot.type.toString();
    }

    public void leave(String plate) throws NotFoundException {
        Vehicle v = findVehicle(plate);
        if (v == null) {
            throw new NotFoundException();
        }
        earned = earned + calculateBill(v, false);
        v.slot.vehicle = null;
        vehicles.remove(v);
    }

    public void passTime(int h) {
        for (int i = 0; i < vehicles.size(); i++) {
            vehicles.get(i).hours = vehicles.get(i).hours + h;
        }
        ArrayList<Vehicle> removeList = new ArrayList<Vehicle>();
        for (int i = 0; i < vehicles.size(); i++) {
            Vehicle v = vehicles.get(i);
            if (v.hours >= maxStay) {
                earned = earned + calculateBill(v,true);
                v.slot.vehicle = null;
                removeList.add(v);
            }
        }
        for (int i = 0; i < removeList.size(); i++) {
            vehicles.remove(removeList.get(i));
        }
    }

    public int freeSlots(SlotType type) {
        int count = 0;
        for (int i = 0; i < slots.size(); i++) {
            if (slots.get(i).type == type && slots.get(i).isFree()) {
                count++;
            }
        }
        return count;
    }
}
