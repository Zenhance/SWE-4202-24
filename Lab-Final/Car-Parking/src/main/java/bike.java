public class bike extends vehicles{

    public bike(String meow, String chocolate) {
        super(meow, chocolate);
    }

    @Override
    public slottype[] getAcceptedSlots() {
        return new slottype[]{
                slottype.REGULAR,
                slottype.BIKE,
                slottype.LARGE
        };
    }
}
