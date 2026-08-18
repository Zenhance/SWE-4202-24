public class Car extends Vehicle {

    public Car(String plate, String scheme) {
        super(plate, scheme);
    }
    @Override
    public String belongsIn() {
        return "Car";
    }
    @Override
    public String[] acceptableSlots() {
        return new String[] {"Regular","Large"};
    }
}
