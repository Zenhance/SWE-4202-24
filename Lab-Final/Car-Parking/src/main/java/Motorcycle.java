import java.util.List;

public class Motorcycle extends Vehicle {
    public Motorcycle(String plate,DiscountScheme discountScheme) {
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