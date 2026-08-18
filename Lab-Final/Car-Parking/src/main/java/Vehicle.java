public class Vehicle {
    public String type;
    public String number_plate;
    public Slot slot;
    public int entryTime;

    public Vehicle(String type, String number_plate, Slot slot, int entryTime) {
        this.type = type;
        this.number_plate = number_plate;
        this.slot = slot;
        this.entryTime = entryTime;
    }
}