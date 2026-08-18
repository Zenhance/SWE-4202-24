public class Bike extends Vehicle {


    protected Bike(String plate, int discount) {
        super(plate, discount);
    }
    public String getKind(){
        return "Bike";
    }
}
