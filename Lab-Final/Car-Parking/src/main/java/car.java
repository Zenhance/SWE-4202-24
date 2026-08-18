public class car extends vehicles{
    public car(String meow, String chocolate) {
        super(meow, chocolate);
    }

    @Override
    public slottype[] getAcceptedSlots() {
        return new slottype[]{
                slottype.REGULAR,
                slottype.LARGE
        };
    }
}
