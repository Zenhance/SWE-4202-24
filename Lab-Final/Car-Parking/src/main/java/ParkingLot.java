import java.util.ArrayList;
public class ParkingLot {
    private int freeBike;
    private int freeRegular;
    private int freeLarge;
    private int maxStay = Integer.MAX_VALUE;
    private int currentTime = 0;
    private int refused = 0;
    private int earned = 0;
    private final ArrayList<Vehicle> parkedVehicles = new ArrayList<>();

    public void setSlots(int bikeSlots, int regularSlots, int largeSlots) {
        freeBike = bikeSlots;
        freeRegular = regularSlots;
        freeLarge = largeSlots;
    }

    public void setMaxStay(int hours) {
        maxStay = hours;
    }

    private boolean isValidRegistration(String registration) {
        return registration.matches("[A-Z]{2}-\\d{2}-\\d{4}");
    }

    private Vehicle findVehicle(String registration) {
        for (Vehicle vehicle : parkedVehicles) {
            if (vehicle.getRegistration().equals(registration)) {
                return vehicle;
            }
        }
        return null;
    }

    public void park(Vehicle vehicle) {
        String registration = vehicle.getRegistration();
        if (!isValidRegistration(registration) || findVehicle(registration) != null) {
            refused++;
            return;
        }
        String[] preferences = vehicle.getSlotPreferences();
        String assignedSlot = null;
        for (String slot : preferences) {
            if (hasFreeSlot(slot)) {
                assignedSlot = slot;
                takeSlot(slot);
                break;
            }
        }
        if (assignedSlot == null) {
            refused++;
            return;
        }
        vehicle.setAssignedSlot(assignedSlot);
        vehicle.setEntryTime(currentTime);
        vehicle.setOversized(!assignedSlot.equals(preferences[0]));
        parkedVehicles.add(vehicle);
    }

    public String getSlot(String registration) {
        Vehicle vehicle = findVehicle(registration);
        if (vehicle == null) {
            return "NONE";
        }
        return vehicle.getAssignedSlot();
    }

    public int getFreeSlots(String slot) {
        if (slot.equals("BIKE")) {
            return freeBike;
        } else if (slot.equals("REGULAR")) {
            return freeRegular;
        } else {
            return freeLarge;
        }
    }
    public int getCount() {
        return parkedVehicles.size();
    }
    public int getRefused() {
        return refused;
    }
    private int calculateBill(Vehicle vehicle) {
        int firstHourFee;
        int extraHourFee;
        if (vehicle.getAssignedSlot().equals("BIKE")) {
            firstHourFee = 10;
            extraHourFee = 5;
        } else if (vehicle.getAssignedSlot().equals("REGULAR")) {
            firstHourFee = 30;
            extraHourFee = 20;
        } else {
            firstHourFee = 50;
            extraHourFee = 40;
        }
        if (vehicle.isOversized()) {
            firstHourFee = firstHourFee * 3 / 2;
        }
        int stayedHours = currentTime - vehicle.getEntryTime();
        int bill = firstHourFee;
        if (stayedHours > 1) {
            bill += (stayedHours - 1) * extraHourFee;
        }
        if (vehicle.getPass().equals("STUDENT")) {
            bill = bill * 80 / 100;
        } else if (vehicle.getPass().equals("WEEKEND")) {
            bill -= firstHourFee;
        }
        return bill;
    }
    public Integer getBill(String registration) {
        Vehicle vehicle = findVehicle(registration);
        if (vehicle == null) {
            return null;
        }
        return calculateBill(vehicle);
    }


}





