import exceptions.NoPlateException;

public class Motorcycle extends Vehicle{
    public Motorcycle(String plate, DiscountScheme discountType) throws NoPlateException {
        super(plate, discountType);
    }
}
