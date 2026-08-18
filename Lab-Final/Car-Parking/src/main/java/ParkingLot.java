import java.util.ArrayList;

public class ParkingLot {
    int maxBikeSlot;
    int maxRegularSlot;
    int maxLargeSlot;

    int bikeSlot = 0;
    int regularSlot = 0;
    int largeSlot = 0;

    int count = 0;
    int refused = 0;

    CalculateCharge c = new CalculateCharge();

    ArrayList<Vehicle> vehicles = new ArrayList<>();
    ArrayList<Vehicle> bikes = new ArrayList<>();
    ArrayList<Vehicle> regulars = new ArrayList<>();
    ArrayList<Vehicle> larges = new ArrayList<>();

    public ParkingLot(int maxBikeSlot, int maxRegularSlot, int maxLargeSlot) {
        this.maxBikeSlot = maxBikeSlot;
        this.maxRegularSlot = maxRegularSlot;
        this.maxLargeSlot = maxLargeSlot;
    }

    public void enterVehicle(Vehicle v){
        vehicles.add(v);
        count++;
    }

    private Vehicle search(String number){
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


    public int getRefused() {
        return refused;
    }

    public int getCount(){
        return count;
    }

    public int getFreeBikeSlot(){
        return maxBikeSlot-bikeSlot;
    }

    public int getFreeRegularSlot(){
        return maxRegularSlot-regularSlot;
    }

    public int getFreeLargeSlot(){
        return maxLargeSlot-largeSlot;
    }

    public ArrayList<Vehicle> getLarges() {
        return larges;
    }

    public ArrayList<Vehicle> getRegulars() {
        return regulars;
    }

    public ArrayList<Vehicle> getBikes() {
        return bikes;
    }

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }

}
