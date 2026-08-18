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

}
