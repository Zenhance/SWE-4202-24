public class Vehicle {
    public String type;
    public String id;
    public Slot slot;
    public int entryTime;

    public Vehicle(String type, String id, Slot slot, int entryTime) {
        this.type = type;
        this.id = id;
        this.slot = slot;
        this.entryTime = entryTime;
    }
}
