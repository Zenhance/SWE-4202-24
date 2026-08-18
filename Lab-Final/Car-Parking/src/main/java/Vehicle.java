public abstract class Vehicle {
    private final String Plate;
    private final String Scheme;
    private int hours;
    private ParkingSlot slot;
    public Vehicle(String Plate, String Scheme) {
        this.Plate = Plate;
        this.Scheme = Scheme;
        this.hours = 0;
    }

    public String getPlate() {
        return Plate;
    }
    public String getScheme() {
        return Scheme;
    }

    public int getHours(){
    return hours;}

    public ParkingSlot getSlot(){
    return slot;
    }
    public void addHours(int amount){
        hours += amount;
    }
    public void setSlot(ParkingSlot slot){
        this.slot = slot;
    }
    public abstract String[] acceptableSlots();

    public abstract String belongsIn();
}
