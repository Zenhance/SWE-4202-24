import java.util.HashMap;

public class Parkinglot {
    //total slots
    private int bikeTotal;
    private int regularTotal;
    private int largeTotal;
    //slots still free
    private int bikeFree;
    private int regularFree;
    private int largeFree;

    private HashMap<String,Vehicle>parkedVehicles = new HashMap<>();
    private int maxStayhrs;
    private int time=0;
    private int refusedCount=0;
    private int totalEarned=0;
}
