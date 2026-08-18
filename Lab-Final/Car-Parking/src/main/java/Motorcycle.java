import java.util.List;

    public final class Motorcycle extends Vehicle {
        public Motorcycle(
                String plate,
                DiscountScheme discount
        ) {
            super(plate, discount);
        }

        @Override
        public List<SlotKind> acceptedSlots() {
            return List.of(
                    SlotKind.BIKE,
                    SlotKind.REGULAR,
                    SlotKind.LARGE
            );
        }
    }
