public abstract class Vehicle {
    private String plate;
    private int hourpass;
    private Slot ownSlot;
    private boolean isParked;
    private PassType pass;
    private static int maxStay;

    public Vehicle(String plate){
        this.plate = plate;
        this.hourpass = 0;
        isParked = false;
    }
    public void setOwnSlot(Slot ownSlot){
        this.ownSlot = ownSlot;
    }

    public int getHourpass(){return hourpass;}

    public static void setMaxStay(int maxStay){
        Vehicle.maxStay = maxStay;
    }
}
