public class bikeslots extends Slot implements Surcharge{
    private static final int firsthour_fee=10;
    private static final int furtherhour_fee=5;
    @Override
    public long fee() {
        return 0;
    }

    @Override
    public long surcharge() {
        return 0;
    }
}
