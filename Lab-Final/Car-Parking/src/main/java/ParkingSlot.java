import java.util.ArrayList;

public class ParkingSlot {
    private int bikeslots;
    private int regularSlots;
    private int largeSlots;
    private int maxStay;
    private int earned;
    private int refused;
    private ArrayList<Vehicle> vehicles;
    public ParkingSlot(int bikeslots,int regularSlots,int largeSlots){
        this.bikeslots=bikeslots;
        this.regularSlots=regularSlots;
        this.largeSlots=largeSlots;
        this.earned=0;
        this.refused=0;
        vehicles=new ArrayList<>();
    }
    public void setMaxStay(int maxStay){
        this.maxStay=maxStay;
    }
}
