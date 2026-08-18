import exceptions.NoPlateException;

public class Truck extends Vehicle{
    public Truck(String plate, String discountType) throws NoPlateException {
        super(plate, discountType);
    }
}
