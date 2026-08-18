import exceptions.NoPlateException;

public class Car extends Vehicle{

    public Car(String plate, DiscountScheme discountType) throws NoPlateException {
        super(plate, discountType);
    }
}
