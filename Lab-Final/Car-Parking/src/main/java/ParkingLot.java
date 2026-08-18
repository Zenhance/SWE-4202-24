import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    List<Vehicle> bikeSlots = new ArrayList<>();
    List<Vehicle> regularSlots = new ArrayList<>();
    List<Vehicle> largeSlots = new ArrayList<>();

    int bikeSlotFirst = 10, bikeSlotFurther = 5, bikeSlotSurcharge = 0;
    int regularSlotFirst = 30, regularSlotFurther = 20, regularSlotSurcharge = 15;
    int largeSlotFirst = 50, largeSlotFurther = 40, largeSlotSurcharge = 25;

    int earned = 0;
    private int maxHours;
    int bikeCapacity;
    int regularCapacity;
    int largeCapacity;
    int count = 0;
    int refused = 0;
    public ParkingLot(int bikeCapacity, int regularCapacity, int largeCapacity) {
        this.bikeCapacity = bikeCapacity;
        this.regularCapacity = regularCapacity;
        this.largeCapacity = largeCapacity;
    }
    public int getMaxHours() {
        return maxHours;
    }
    public void setMaxHours(int maxHours) {
        this.maxHours = maxHours;
    }

    public int getBikeCapacity() {
        return bikeCapacity;
    }

    public void setBikeCapacity(int bikeCapacity) {
        this.bikeCapacity = bikeCapacity;
    }

    public int getRegularCapacity() {
        return regularCapacity;
    }

    public void setRegularCapacity(int regularCapacity) {
        this.regularCapacity = regularCapacity;
    }

    public int getLargeCapacity() {
        return largeCapacity;
    }

    public void setLargeCapacity(int largeCapacity) {
        this.largeCapacity = largeCapacity;
    }
    public void addVehicle(Vehicle vehicle) {
        boolean added = false;
        if(vehicle instanceof Bike){
            if(bikeCapacity != 0){
                bikeSlots.add(vehicle);
                added = true;
            }else if(regularCapacity != 0){
                regularSlots.add(vehicle);
                added = true;
            }else if(largeCapacity != 0){
                largeSlots.add(vehicle);
                added = true;
            }
            try{
                if(added == false){
                    throw new NoSlotLeftException("No slots left");
                }
            }catch(NoSlotLeftException e){
                refused++;
            }
        }else if(vehicle instanceof Car){
            if(regularCapacity != 0){
                regularSlots.add(vehicle);
                 added = true ;

            }else if(largeCapacity != 0){
                largeSlots.add(vehicle);
                 added = true;
            }
            try{
                if(added == false){
                    throw new NoSlotLeftException("No slots left");
                }
            }catch(NoSlotLeftException e){
                refused++;
            }
        }else if(vehicle instanceof Truck){
            if(largeCapacity != 0){
                largeSlots.add(vehicle);
                added = true;
            }
            try{
                if(added == false){
                    throw new NoSlotLeftException("No slots left");
                }
            }catch(NoSlotLeftException e){
                refused++;
            }
        }
    }
    public void addBike(Vehicle vehicle){
        bikeSlots.add(vehicle);
        bikeCapacity -= 1;
        count++;
    }
    public void addRegular(Vehicle vehicle){
        regularSlots.add(vehicle);
        regularCapacity -= 1;
        count++;
    }
    public void addLarge(Vehicle vehicle){
        largeSlots.add(vehicle);
        largeCapacity -= 1;
        count++;
    }
    public void leavePlate(String plate){
        for (Vehicle vehicle : bikeSlots) {
            if(vehicle.numberPlate.equals(plate)){
                bikeSlots.remove(vehicle);
                bikeCapacity += 1;
                count--;
                break;

            }
        }
        for (Vehicle vehicle : regularSlots) {
            if(vehicle.numberPlate.equals(plate)){
                regularSlots.remove(vehicle);
                regularCapacity += 1;
                count--;
                break;
            }
        }
        for (Vehicle vehicle : largeSlots) {
            if(vehicle.numberPlate.equals(plate)){
                largeSlots.remove(vehicle);
                largeCapacity += 1;
                count--;
                break;
            }
        }
    }

}
