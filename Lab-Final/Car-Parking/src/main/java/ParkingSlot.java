import java.security.PublicKey;

public  class ParkingSlot {
    public static final ParkingSlot REGULAR=null;
    public static final ParkingSlot LARGE=null;
    private String plate;
    public double discount;
    private int freeBike;
    private int freeRegular;
    private int freeLarge;
    private int maxStay;
    public void setSlots(
            int bikeSlots,
            int regularSlots,
            int largeSlots) {
        freeBike=bikeSlots;
        freeRegular=regularSlots;
        freeLarge=largeSlots;

    }
    public ParkingSlot(String plate , double discount){
        this.plate=plate;
        this.discount=discount;
    }

    public void setMaxStay(int hours) {
        this.maxStay=hours;
    }
}
