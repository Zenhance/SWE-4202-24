import java.util.ArrayList;

public abstract class Vehicle {
    public ArrayList<ParkingSlot> Slots= new ArrayList<>();
    private String registration,pass;
    private String assignedSlot;
    private int entryTime;
    private final String plate;
    private final int discount;
    protected Vehicle(String plate,int  discount) {
        this.plate=plate;
        this.discount=discount;
    }
    public String getPlate() {
        return plate;
    }
    public int getDiscount() {
        return discount;
    }
    public abstract String getKind();
    public String getAssignedSlot() {
        return assignedSlot;
    }
    public void setAssignedSlot(String assignedSlot) {
        this.assignedSlot=assignedSlot;
    }
    public int getEntryTime() {
        return entryTime;
    }
    public void setEntryTime(int entryTime) {
        this.entryTime = entryTime;
    }


}