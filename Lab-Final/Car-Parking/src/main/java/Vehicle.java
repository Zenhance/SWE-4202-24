import java.lang.reflect.Type;

public class Vehicle {
    private Type type;
    private Scheme scheme;
    private int entry;
    private String plate;

    public Vehicle(Type type, Scheme scheme, int entry, String plate){
        this.type=type;
        this.scheme=scheme;
        this.entry=entry;
        this.plate=plate;
    }

    public Type getType(){
        return type;
    }
    public Scheme getScheme(){
        return scheme;
    }
    public int getEntry(){
        return entry;
    }
    public String getPlate(){
        return plate;
    }

    public int getParkedHours(int current){
        return current-entry;
    }

    private Slot slot;

    public void setSlot(Slot slot){
        this.slot=slot;
    }

    public Slot getSlot(){
        return slot;
    }
}
