import java.util.ArrayList;
import java.util.List;

public class CarPark {
    private int freeBike;
    private int freeRegular;
    private int freeLarge;
    private int maxStay;
    private int earned = 0;
    private int refused = 0;
    private final List<Vehicle> vehicleParked = new ArrayList<>();

    public void setMaxStay(int hours) {
        this.maxStay = hours;
    }

    public void setSlots(int Bike, int Regular, int Large) {
        this.freeBike = Bike;
        this.freeRegular = Regular;
        this.freeLarge = Large;
    }

        private Vehicle search(String plate){
            for (Vehicle v : vehicleParked) {
                if (v.getPlate().equals(plate)) {
                    return v;
                }
            }
            return null;
        }
    }

