import java.util.List;
public class Car extends Vehicle {
    public Car(String plate,DiscountScheme discountScheme) {
        super(plate,discountScheme);
    }

    @Override



    public VehicleType getVehicleType() {
        return VehicleType.CAR;
    }

    @Override

    public List<SlotType> getPreferredSlotTypes() {
        return List.of(SlotType.REGULAR,SlotType.LARGE
        );
    }
}
