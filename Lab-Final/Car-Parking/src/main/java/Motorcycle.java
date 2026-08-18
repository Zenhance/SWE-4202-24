import exceptions.NoPlateException;

public class Motorcycle extends Vehicle{
    public Motorcycle(String plate, String discountType) throws NoPlateException {
        super(plate, discountType);
    }
}
