public class Slot {
    private int bikeSlot;
    private int regularSlot;
    private int largeSlot;
    private int MAXSTAY;
    private static int count=0;
    private int PASSTIME;

    Slot(int bikeSlot, int regularSlot, int largeSlot){
        this.bikeSlot=bikeSlot;
        this.regularSlot=regularSlot;
        this.largeSlot=largeSlot;
    }



    public static int getCount() {
        return count;
    }

    public int getBikeSlot() {
        return bikeSlot;
    }

    public int getRegularSlot() {
        return regularSlot;
    }

    public int getLargeSlot() {
        return largeSlot;
    }

    public int getSlot(){
        return bikeSlot+regularSlot+largeSlot;
    }

}
