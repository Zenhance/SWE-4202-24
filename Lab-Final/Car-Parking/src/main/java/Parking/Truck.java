package Parking;
public class Truck extends Vehicle{
    public Truck(String plate, String scheme) {
        super(plate, scheme);
    }
    @Override
    public String[] acceptableSlots(){
        return new String[]{"LARGE"};
    }
    @Override
    public String belongsIn() {
        return "LARGE";
    }
}