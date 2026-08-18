public class Bike extends Vehicle {
    public Bike(String plate, String discount) {
        super(plate, discount);
    }

}
@Override
   String[] getAcceptedslots(){
    return new String[]{"BIKE", "REGULAR", "LARGE"};
}