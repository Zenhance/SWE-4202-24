public abstract class Vehicle {
    private final String plate;
    private final Category category;
    private SlotType assignedSlot;
    private int entryTime;

    protected Vehicle(String plate, Category category) {
        this.plate = plate;
        this.category = category;

    }
    //getters
    public String getPlate(){
        return plate;
    }
    public Category getCategory(){
        return category;
    }
    public SlotType getAssignedSlot(){
        return assignedSlot;
    }
    public int getEntryTime(){
        return entryTime;
    }
    public void park(SlotType slot,int time){
        this.assignedSlot=slot;
        this.entryTime=time;
    }
    public abstract SlotType[] prefferedSlot();
    public abstract int hourlyRate();
}
