package Parking;
public class Motorcycle extends Vehicle{
    public  Motorcycle(String plate, String scheme){
        super(plate, scheme);
    }

@Override
public String[] acceptableSlots() {
    return new String[] {"BIKE", "REGULAR", "LARGE"};
    }

    @Override
    public String belongsIn() {
        return "BIKE";
    }
}
