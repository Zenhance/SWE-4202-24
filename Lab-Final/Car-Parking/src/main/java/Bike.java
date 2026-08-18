public class Bike extends Vehicle {


    protected Bike(String plate, DiscountScheme discount) {
        super(plate, discount);
    }
    public String getKind(){
        return "Bike";
    }
}
