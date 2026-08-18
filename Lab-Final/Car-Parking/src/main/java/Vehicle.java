public abstract class Vehicle {
    private final String vehiclePlate;
    private final Category category;
    private SlotType keptSlot;
    private int entryTime;
    protected Vehicle(String vehiclePlate,Category category){
       this.vehiclePlate=vehiclePlate;
       this.category=category;
    }
    public String getVehiclePlate(){
        return vehiclePlate;
    }
    public Category getCategory(){
        return category;
    }
    public SlotType getKeptSlot(){
        return keptSlot;
    }
    public int getEntryTime(){
        return entryTime;
    }
    public void park(SlotType slot,int getTime){
        this.keptSlot=slot;
        this.entryTime=getTime;
    }
    public abstract SlotType[] slotPreference();
    public abstract int hourlyRate();
}
