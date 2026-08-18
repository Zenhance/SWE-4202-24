public abstract class Vehicle {
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
    public String getRegistration() {
        return registration;
    }
    public String getPass() {
        return pass;
    }
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