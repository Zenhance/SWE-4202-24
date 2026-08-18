import java.util.ArrayList;
import java.util.List;

public class Carkpark {
    private int freeBike;
    private int freeRegular;
    private int freeLarge;
    private int maxStay;
    private int earned=0;
    private int refused=0;

    private final List<Vehicle> parkedVehicle=new ArrayList<>();

    public void setSlots(int bike,int regular,int large){
        this.freeBike=bike;
        this.freeRegular=regular;
        this.freeLarge=large;
    }

    public void setMaxStay(int hours){
        maxStay=hours;
    }
     public int freeCount(SlotType type){
        return switch(type){
            case BIKE -> freeBike;
            case REGULAR -> freeLarge;
            case LARGE -> freeLarge;
        };
     }

     private Vehicle find(String plate){
        for(Vehicle v: parkedVehicle){
            if(v.getPlate().equals(plate)){
                return v;
            }
        }
        return null;
     }
}
