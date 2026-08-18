import java.security.PublicKey;
import java.util.ArrayList;

public abstract class Vehicle {
    public ArrayList<ParkingSlot> Slots= new ArrayList<>();
    private String registration,pass;
    private ParkingSlot assignedSlot;
    private int entryTime;
    private final String plate;
    private final int discount;
    protected Vehicle(String plate,int  discount) {
        this.plate=plate;
        this.discount=discount;
    }
    public void park(ParkingSlot slot,int time){
        this.assignedSlot=slot;
        this.entryTime=time;
    }
    public String getPlate() {
        return plate;
    }
    public int getDiscount() {
        return discount;
    }
    public abstract String getKind();
    public ParkingSlot getAssignedSlot() {
        return assignedSlot;
    }
    public void setAssignedSlot(ParkingSlot assignedSlot) {
        this.assignedSlot=assignedSlot;
    }
    public int getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(int entryTime) {
        this.entryTime = entryTime;
    }
    public abstract ParkingSlot[] slot();

}