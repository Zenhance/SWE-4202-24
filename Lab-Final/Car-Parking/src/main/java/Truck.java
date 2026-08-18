import exceptions.NoPlateException;

public class Truck extends Vehicle{

    public Truck(String plate, DiscountScheme discountType) throws NoPlateException {
        super(plate, discountType);
    }
}
