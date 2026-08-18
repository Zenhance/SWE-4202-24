public class Truck extends Vehicle{


    public Truck(String plate, DiscountScheme discount) {
        super(plate, discount);
    }
    public String getKind(){
        return "Truck";
    }
}
