public abstract class Vehicle {
    private final String vehiclePlate;
    private final Category category;
    private SlotType keptSlot;
    private int entryTime;
    protected Vehicle(String vehiclePlate,Category category){
       this.vehiclePlate=vehiclePlate;
       this.category=category;

    }
}
