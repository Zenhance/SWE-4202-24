public abstract class Vehicle {
    private final String plate;
    private final Category category;
    private SlotType assignedSlot;
    private int entryTime;

    protected Vehicle(String plate, Category category) {
        this.plate = plate;
        this.category = category;

    }
    public String getPlate(){
        return plate;
    }
    public Category getCategory(){
        return category;
    }
    public SlotType getAssignedSlot(){
        return assignedSlot;
    }
}
