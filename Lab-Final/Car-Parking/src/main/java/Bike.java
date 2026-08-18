import java.util.List;

public class Bike extends Vehicle {
    public Bike(String plate, DiscountScheme discountScheme) {
        super(plate,discountScheme);
    }

    @Override
    public VehicleType getVehicleType() {
        return VehicleType.BIKE;
    }

    @Override
    public List<SlotType> getPreferredSlotTypes() {
        return List.of(SlotType.BIKE, SlotType.REGULAR,SlotType.LARGE
        );
    }
}