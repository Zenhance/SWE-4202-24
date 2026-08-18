import java.lang.reflect.Type;

public class Slot {
    public enum Type{
        BIKE,CAR,TRUCK;
    }

    private Type type;
    private Vehicle vehicle;

    public Slot(Type type){
        this.type=type;
    }

    public boolean isFree(){
        return vehicle==null;
    }

    public Vehicle getVehicle(){
        return vehicle;
    }



}
