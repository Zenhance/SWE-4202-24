import java.util.HashMap;

public class Parkinglot {

    private int bikeTotal;
    private int regularTotal;
    private int largeTotal;
    private int bikeFree;
    private int regularFree;
    private int largeFree;
    private HashMap<String,Vehicle>parkedVehicles = new HashMap<>();
    private int maxStayhrs;
    private int time=0;
    private int refusedCount=0;
    private int totalEarned=0;

    public void setSlots(int bike,int regular,int large){
        bikeTotal=bike;
        regularTotal=regular;
        largeTotal=large;
        regularFree=regular;
        largeFree=large;
    }
    public void setMaxStay(int hrs){
        maxStayhrs=hrs;
    }
    public void advanceTime(int hrs){
        time+=hrs;
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
