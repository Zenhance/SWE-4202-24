package Records;

public class slotCount {
    private static  int bike;
    private static int regular;
    private static int large;
    public static int vehicleCount=0;
    public static int refuseCount=0;
    public static int getBikeCount(){
        return bike;
    }
    public static int getRegularCount(){
        return regular;
    }
    public static int getLargeCount(){
        return large;
    }
    public static void Count(){
        vehicleCount++;
    }
    public static void RefuseCount(){
        refuseCount++;
    }
    public static int getCount(){
        return vehicleCount;
    }
    public static int getRefuseCount(){
        return refuseCount;
    }

    public static void setBike(int bike) {
        slotCount.bike = bike;
    }

    public static void setRegular(int regular) {
        slotCount.regular = regular;
    }

    public static void setLarge(int large) {
        slotCount.large = large;
    }
    public static void addBike(){
        bike++;
    }
    public static void addRegular(){
        regular++;
    }
    public static void addLarge(){
        large++;
    }
    public static void removeBike(){
        bike-- ;
    }
    public static void removeRegular(){
        regular-- ;
    }
    public static void removeLarge(){
        large-- ;
    }
}
