import java.util.ArrayList;

public class ParkingLot {
    int maxBikeSlot;
    int maxRegularSlot;
    int maxLargeSlot;

    int bikeSlot;
    int regularSlot;
    int largeSlot;


    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Vehicle> bikes = new ArrayList<>();
    static ArrayList<Vehicle> regulars = new ArrayList<>();
    static ArrayList<Vehicle> larges = new ArrayList<>();

    public ParkingLot(int maxBikeSlot, int maxRegularSlot, int maxLargeSlot) {
        this.maxBikeSlot = maxBikeSlot;
        this.maxRegularSlot = maxRegularSlot;
        this.maxLargeSlot = maxLargeSlot;

        this.bikeSlot = maxBikeSlot;
        this.regularSlot = maxRegularSlot;
        this.largeSlot = maxLargeSlot;
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
        Vehicle v = search(number);
        if(v != null){
            Bike bike;
            Car car;
            Truck truck;

            if(v instanceof Bike){
                bike = (Bike)v;
                if(bikeSlot < maxBikeSlot) bikes.add(bike);

            }
        }
    }



}
