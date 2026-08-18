package Records;

public class slotCount {
    private int bike;
    private int regular;
    private int large;
    public static int vehicleCount;
    public int bikeCount(){
        return bike;
    }
    public int regularCount(){
        return regular;
    }
    public int largeCount(){
        return large;
    }
    public static void Count(){
        vehicleCount++;
    }
    public static int getCount(){
        return vehicleCount;
    }
}
