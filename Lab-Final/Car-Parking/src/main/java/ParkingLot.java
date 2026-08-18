import java.util.ArrayList;

public class ParkingLot {
    int bikeSlot;
    int regularSlot;
    int largeSlot;
    static ArrayList<Vehicle> vehicles = new ArrayList<>();

    public ParkingLot(int bikeSlot, int regularSlot, int largeSlot) {
        this.bikeSlot = bikeSlot;
        this.regularSlot = regularSlot;
        this.largeSlot = largeSlot;
    }

    public void enterVehicle(Vehicle v){
        vehicles.add(v);
    }

    public static Vehicle search(String number){
        for(Vehicle v: vehicles){
            if(number.equals(v.number)) return v;
        }
        return null;
    }

    public void slotVehicle (String number){

    }

}
