package Parking;
public class Car extends Vehicle{
    public Car(String plate, String scheme){
        super(plate, scheme);
    }
    @Override
    public String[] acceptableSlots(){
        return new String[]{"REGULAR", "LARGE"};
    }
    @Override
    public String belongsIn() {
        return "REGULAR";
    }
}