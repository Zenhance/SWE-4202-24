import java.security.PrivateKey;
import java.util.ArrayList;

public  class ParkingSlot {

    public static final ParkingSlot REGULAR=null;
    public static final ParkingSlot LARGE=null;
    public static final ParkingSlot Bike=null;
    public int bikeCapacity,regularCapacity,largeCapacity;
    private int count=0;
    private String plate,discount;
    private int freeBike;
    private int freeRegular;
    private int freeLarge;
    private int maxStay;
    public ParkingSlot(int bikeSlots,
                       int regularSlots,
                       int largeSlots) {
        freeBike=bikeSlots;
        freeRegular=regularSlots;
        freeLarge=largeSlots;
        for(int i=0;i<bikeSlots;i++){
            System.out.println("Bike");
        }
        for(int i=0;i<largeSlots;i++){
            System.out.println("LARGE");
        }
        for(int i=0;i<regularSlots;i++){
            System.out.println("REGULAR");
        }
    }
    public void setMaxStay(int hours) {
        this.maxStay=hours;
    }
    public int getFreeBike() {
        return freeBike;
    }
    public int getFreeRegular() {
        return freeRegular;
    }
    public int getFreeLarge() {
        return freeLarge;
    }
    public int getMaxStay() {
        return maxStay;
    }

    public void setFreeBike(int freeBike) {
        this.freeBike = freeBike;
    }

    public void setFreeLarge(int freeLarge) {
        this.freeLarge = freeLarge;
    }

    public void setFreeRegular(int freeRegular) {
        this.freeRegular = freeRegular;
    }
    public int getCount() {
        return count;
    }
}
