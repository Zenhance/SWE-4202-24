public class truck extends vehicles{
    public truck(String meow, String chocolate) {
        super(meow, chocolate);
    }

    @Override
    public slottype[] getAcceptedSlots() {
        return new slottype[]{
                slottype.LARGE
        };
    }
}
