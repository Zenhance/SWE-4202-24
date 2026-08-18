public class Vehicle {
    public enum Type {
        BIKE,CAR,TRUCK
    }
    public enum Scheme {
        NONE,STUDENT,WEEKEND
    }

    private Type type;
    private Scheme scheme;
    private int entry;
    private String plate;
    private Catagory catagory;

    public Vehicle(Type type,String plate,Scheme scheme,int entry){
        this.type = type;
        this.plate = plate;
        this.scheme = scheme;
        this.entry = entry;
    }

    public Type getType() {
        return type;
    }

    public Scheme getScheme() {
        return scheme;
    }

    public int getEntry() {
        return entry;
    }

    public String getPlate() {
        return plate;
    }

    public int getParkedHours(int current){
        return current - entry;
    }

    private Slot slot;
    public void setSlot(Slot slot){
        this.slot = slot;
    }
    public Slot getSlot(){
        return slot;
    }

    public Catagory getCatagory(){
        return catagory;
    }
}
