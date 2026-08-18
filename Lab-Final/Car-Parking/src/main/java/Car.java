public class Car extends Vehicle {
    public Car(String plate, String discount) {
        super(plate, discount);
    }

    @Override
    String[] getAcceptedSlots() {
        return new String[]{"REGULAR", "LARGE"};
    }
}


