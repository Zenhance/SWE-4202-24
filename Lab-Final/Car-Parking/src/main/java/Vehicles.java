import java.util.ArrayList;
import java.util.List;

public class Vehicles {
    String plate;
    String slot;
    String scheme;
    Boolean evict=false;
    int time=1;
    int fee(){
        int fee=fee+(time-1)*fee;
    }
    public Vehicles(String plate) {
        this.plate = plate;
    }
}
