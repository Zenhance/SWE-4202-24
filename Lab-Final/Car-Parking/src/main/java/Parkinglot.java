import java.util.HashMap;

public class Parkinglot {

    private int bikeTotal;
    private int regularTotal;
    private int largeTotal;
    private int bikeFree;
    private int regularFree;
    private int largeFree;
    private HashMap<String, Vehicle> parkedVehicles = new HashMap<>();
    private int maxStayhrs;
    private int time = 0;
    private int refusedCount = 0;
    private int totalEarned = 0;

    public void setSlots(int bike, int regular, int large) {
        bikeTotal = bike;
        regularTotal = regular;
        largeTotal = large;
        regularFree = regular;
        largeFree = large;
    }

    public void setMaxStay(int hrs) {
        maxStayhrs = hrs;
    }

    public void advanceTime(int hrs) {
        time += hrs;
    }


    private int getFreeSlots(slotType type) {
        if (type == slotType.BIKE) {
            return bikeFree;
        } else if (type == slotType.REGULAR) {
            return regularFree;
        } else {
            return largeFree;
        }
    }

    private void takeOneSlot(slotType type) {
        if (type == slotType.BIKE) {
            bikeFree = bikeFree - 1;
        } else if (type == slotType.REGULAR) {
            regularFree = regularFree - 1;
        } else {
            largeFree = largeFree - 1;
        }
    }


    private void returnOneSlot(slotType type) {
        if (type == slotType.BIKE) {
            bikeFree = bikeFree + 1;
        } else if (type == slotType.REGULAR) {
            regularFree = regularFree + 1;
        } else {
            largeFree = largeFree + 1;
        }
    }


    public void register(Vehicle vehicle) {
        slotType[] choices = vehicle.prefferedSlot();

        for (int i = 0; i < choices.length; i++) {
            slotType type = choices[i];
            if (getFreeSlots(type) > 0) {
                takeOneSlot(type);
                vehicle.park(type, time);
                parkedVehicles.put(vehicle.getVehiclePlate(), vehicle);
                return;
            }
        }
        refusedCount = refusedCount + 1;
    }

    public slotType slotOf(String plate) {
        Vehicle v = parkedVehicles.get(plate);
        if (v == null) {
            return null;
        }
        return v.getKeptslot();
    }

    public int freeCount(slotType type) {
        return getFreeSlots(type);
    }

    public int parkedCount() {
        return parkedVehicles.size();
    }
    public int refusedCount() {
        return refusedCount;
    }

    public int totalEarned() {
        return totalEarned;
    }
    public Integer billFor(String plate) {
        Vehicle v = parkedVehicles.get(plate);
        if (v == null) {
            return null;
        }
        int hoursParked = time - v.getTime();
        return calculateFee(v, hoursParked);
    }

    private int calculateFee(Vehicle v, int hoursParked) {
        int hours = hoursParked;
        if (hours < 1) {
            hours = 1;
        }
        int fee = v.hourlyRate() * hours;

        if (hours > maxStayhrs) {
            fee = fee + v.hourlyRate() * (hours - maxStayhrs);
        }
        if (v.getCategory() == Category.STUDENT) {
            fee = fee / 2;
        }

        return fee;




    }

    public Integer leave(String plate) {
        Vehicle v = parkedVehicles.remove(plate);
        if (v == null) {
            return null;
        }
        int hoursParked =time - v.getTime();
        int fee = calculateFee(v, hoursParked);
        totalEarned = totalEarned + fee;
        returnOneSlot(v.getKeptslot());
        return fee;}






}











