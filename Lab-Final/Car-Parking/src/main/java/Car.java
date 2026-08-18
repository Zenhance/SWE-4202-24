import exceptions.NoPlateException;

public class Car extends Vehicle{
    public Car(String plate, String discountType) throws NoPlateException {
        super(plate, discountType);
    }
}
