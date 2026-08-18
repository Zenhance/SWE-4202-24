import java.util.ArrayList;

public class ParkingLot {
    int maxBikeSlot;
    int maxRegularSlot;
    int maxLargeSlot;

    int bikeSlot = 0;
    int regularSlot = 0;
    int largeSlot = 0;

    static int count = 0;
    static int refused = 0;

    static ArrayList<Vehicle> vehicles = new ArrayList<>();
    static ArrayList<Vehicle> bikes = new ArrayList<>();
    static ArrayList<Vehicle> regulars = new ArrayList<>();
    static ArrayList<Vehicle> larges = new ArrayList<>();

    public ParkingLot(int maxBikeSlot, int maxRegularSlot, int maxLargeSlot) {
        this.maxBikeSlot = maxBikeSlot;
        this.maxRegularSlot = maxRegularSlot;
        this.maxLargeSlot = maxLargeSlot;
    }

    public void enterVehicle(Vehicle v){
        vehicles.add(v);
        count++;
    }

    private static Vehicle search(String number){
        for(Vehicle v: vehicles){
            if(number.equals(v.number)) return v;
        }
        return null;
    }

    private String addBike(Bike bike){
        if(bikeSlot < maxBikeSlot) {
            bikes.add(bike);
            bikeSlot++;
            return "BIKE";
        }
        else if(regularSlot < maxRegularSlot) {
            regulars.add(bike);
            regularSlot++;
            return "REGULAR";
        }
        else if(largeSlot < maxLargeSlot) {
            larges.add(bike);
            largeSlot++;
            return "LARGE";
        }
        else {
            refused++;
            return "NONE";
        }
    }

    private String addCar(Car car){
        if(regularSlot < maxRegularSlot) {
            regulars.add(car);
            regularSlot++;
            return "REGULAR";
        }
        else if(largeSlot < maxLargeSlot) {
            larges.add(car);
            largeSlot++;
            return "LARGE";

        }
        else {
            refused++;
            return "NONE";
        }
    }

    private String addTruck(Truck truck){
        if(largeSlot < maxLargeSlot) {
            larges.add(truck);
            largeSlot++;
            return "LARGE";
        }
        else {
            refused++;
            return "NONE";
        }
    }

    public String slotVehicle (String number){
        Vehicle v = search(number);
        if (v != null){
            if (v instanceof Bike bike){
                return addBike(bike);
            }
            else if (v instanceof Car car){
                addCar(car);
                return addCar(car);
            }
            else if (v instanceof Truck truck){
                addTruck(truck);
                return addTruck(truck);
            }
        }
        return null;
    }



    public static ArrayList<Vehicle> getLarges() {
        return larges;
    }

    public static ArrayList<Vehicle> getRegulars() {
        return regulars;
    }

    public static ArrayList<Vehicle> getBikes() {
        return bikes;
    }

    public static ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

    public static int getReturned() {
        return refused;
    }


}
