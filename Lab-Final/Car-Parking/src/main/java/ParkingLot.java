import java.util.ArrayList;

public class ParkingLot {
    int maxBikeSlot;
    int maxRegularSlot;
    int maxLargeSlot;

    int bikeSlot = 0;
    int regularSlot = 0;
    int largeSlot = 0;

    static int count = 0;
    static int returned = 0;

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
    }

    private static Vehicle search(String number){
        for(Vehicle v: vehicles){
            if(number.equals(v.number)) return v;
        }
        return null;
    }

    private void addBike(Bike bike){
        if(bikeSlot < maxBikeSlot) {
            bikes.add(bike);
            bikeSlot++;
        }
        else if(regularSlot < maxBikeSlot) {
            regulars.add(bike);
            regularSlot++;
        }
        else if(largeSlot < maxLargeSlot) {
            larges.add(bike);
            largeSlot++;
        }
        else returned++;
    }

    private void addCar(Car car){
        if(regularSlot < maxBikeSlot) {
            regulars.add(car);
            regularSlot++;
        }
        else if(largeSlot < maxLargeSlot) {
            larges.add(car);
            largeSlot++;
        }
        else returned++;
    }

    private void addTruck(Truck truck){
        if(regularSlot < maxBikeSlot) {
            regulars.add(truck);
            regularSlot++;
        }
        else if(largeSlot < maxLargeSlot) {
            larges.add(truck);
            largeSlot++;
        }
        else returned++;
    }

    public void slotVehicle (String number){
        Vehicle v = search(number);
        if (v != null){
            if (v instanceof Bike){
                Bike bike = (Bike)v;
                addBike(bike);
            }
            else if (v instanceof Car){
                Car car = (Car)v;
                addCar(car);
            }
            else if (v instanceof Truck){
                Truck truck = (Truck)v;
                addTruck(truck);
            }
        }
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
        return returned;
    }
}
