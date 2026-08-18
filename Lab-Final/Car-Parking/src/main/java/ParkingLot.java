import java.util.ArrayList;
import java.util.List;
public class ParkingLot {
    List<Vehicle> bikeSlots = new ArrayList<>();
    List<Vehicle> regularSlots = new ArrayList<>();
    List<Vehicle> largeSlots = new ArrayList<>();

    private int earned = 0;
    private int maxHours;
    private int bikeCapacity;
    private int regularCapacity;
    private int largeCapacity;
    private int count = 0;
    private int refused = 0;

    public ParkingLot(int bikeCapacity, int regularCapacity, int largeCapacity) {
        this.bikeCapacity = bikeCapacity;
        this.regularCapacity = regularCapacity;
        this.largeCapacity = largeCapacity;
    }

    private int calculatedFee(int hoursParked, SlotType slotType) {
        if (hoursParked <= 0) {
            return 0;
        }

        int fee = slotType.getFirstHour();
        if (hoursParked > 1) {
            fee += (hoursParked - 1) * slotType.getFurtherHour();
        }

        if (hoursParked > maxHours) {
            fee += slotType.getSurcharge();
        }
        return fee;
    }

    public void addVehicle(Vehicle vehicle) throws NoSlotLeftException {
        boolean added = false;

        if (vehicle instanceof Bike) {
            if (bikeCapacity > 0) {
                addBike(vehicle);
                added = true;
            } else if (regularCapacity > 0) {
                addRegular(vehicle);
                added = true;
            } else if (largeCapacity > 0) {
                addLarge(vehicle);
                added = true;
            }
        } else if (vehicle instanceof Car) {
            if (regularCapacity > 0) {
                addRegular(vehicle);
                added = true;
            } else if (largeCapacity > 0) {
                addLarge(vehicle);
                added = true;
            }
        } else if (vehicle instanceof Truck) {
            if (largeCapacity > 0) {
                addLarge(vehicle);
                added = true;
            }
        }
        if (!added) {
            refused++;
            throw new NoSlotLeftException();
        }
    }

    public void addBike(Vehicle vehicle) {
        bikeSlots.add(vehicle);
        bikeCapacity--;
        count++;
    }

    public void addRegular(Vehicle vehicle) {
        regularSlots.add(vehicle);
        regularCapacity--;
        count++;
    }


    public void addLarge(Vehicle vehicle) {
        largeSlots.add(vehicle);
        largeCapacity--;
        count++;
    }

    public void leavePlate(String plate, int hoursParked) throws NotInTheParkException {
        for (int i = 0; i < bikeSlots.size(); i++) {
            Vehicle vehicle = bikeSlots.get(i);
            if (vehicle.plate.equals(plate)) {
                bikeSlots.remove(i);
                bikeCapacity++;
                count--;
                earned += calculateFee(hoursParked, SlotType.BIKE);
                return;
            }
        }
        for (int i = 0; i < regularSlots.size(); i++) {
            Vehicle vehicle = regularSlots.get(i);
            if (vehicle.plate.equals(plate)) {
                regularSlots.remove(i);
                regularCapacity++;
                count--;
                earned += calculateFee(hoursParked, SlotType.REGULAR);
                return;
            }
        }
        for (int i = 0; i < largeSlots.size(); i++) {
            Vehicle vehicle = largeSlots.get(i);
            if (vehicle.plate.equals(plate)) {
                largeSlots.remove(i);
                largeCapacity++;
                count--;
                earned += calculateFee(hoursParked, SlotType.LARGE);
                return;
            }
        }
        throw new NotInTheParkException();
    }

    public int getEarned() {
        return earned;
    }

    public int getRefused() {
        return refused;
    }

    public int getMaxHours() {
        return maxHours;
    }

    public void setMaxHours(int maxHours) {
        this.maxHours = maxHours;
    }

    public int getBikeCapacity() {
        return bikeCapacity;
    }

    public void setBikeCapacity(int bikeCapacity) {
        this.bikeCapacity = bikeCapacity;
    }

    public int getregularCapacity() {
        return regularCapacity;
    }

    public void setregularCapacity(int regularCapacity) {
        this.regularCapacity = regularCapacity;
    }

    public int getlargeCapacity() {
        return largeCapacity;
    }

    public void setlargeCapacity(int largeCapacity) {
        this.largeCapacity = largeCapacity;
    }
}



