import java.util.ArrayList;
import java.util.List;

public class CarPark{
    private int freeBike;
    private int freeRegular;
    private int freeLarge;
    private int maxStay;
    private int earned=0;
    private int refused=0;

    private final List<Vehicle> parkedVehicle=new ArrayList<>();

    public void setSlots(int bike,int regular,int large){
        this.freeBike=bike;
        this.freeLarge=large;
        this.freeRegular=regular;
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
    private Vehicle find(String numberPlate){
        for (Vehicle v:parkedVehicle){
            if(v.getNumberPlate().equals(numberPlate)){
                return v;
            }
        }
        return null;
    }


}