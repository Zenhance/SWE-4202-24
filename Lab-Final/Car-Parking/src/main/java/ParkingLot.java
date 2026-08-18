import java.util.ArrayList;
public class ParkingLot{
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
    public void setMaxStay(int hours){
        maxStay = hours;
    }
    private boolean isValidRegistration(String registration) {
        return registration.matches("[A-Z]{2}-\\d{2}-\\d{4}");
    }
    private Vehicle findVehicle(String registration){
        for (Vehicle vehicle : parkedVehicles){
            if (vehicle.getRegistration().equals(registration)){
                return vehicle;
            }
        }
        return null;
    }

    public void park(Vehicle vehicle) {
        String registration = vehicle.getRegistration();
        if (!isValidRegistration(registration) || findVehicle(registration) != null){
            refused++;
            return;
        }
        String[] preferences = vehicle.getSlotPreferences();
        String assignedSlot = null;
        for (String slot : preferences) {
            if (hasFreeSlot(slot)){
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

