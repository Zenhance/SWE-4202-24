public class largeslots extends Slot implements Surcharge{
    private static final int firsthour_fee=50;
    private static final int furtherhour_fee=40;
    @Override
    public long fee() {
        return 0;
    }

    @Override
    public long surcharge() {
        return 0;
    }
}
