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
    public void park(Vehicle vehicle) {
        String registration = vehicle.getRegistration();
        if (!isValidRegistration(registration) || findVehicle(registration) != null){
            refused++;
            return;
        }
        String[] preferences = vehicle.getSlotPreferences();
        String assignedSlot = null;

    }
