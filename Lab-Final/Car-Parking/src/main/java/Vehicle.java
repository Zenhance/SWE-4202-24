public class Vehicle {
    private Type type;
    private Scheme scheme;
    private int entry;
    private String plate;

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
}
