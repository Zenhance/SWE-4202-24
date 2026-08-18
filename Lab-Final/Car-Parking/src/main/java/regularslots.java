public class regularslots extends Slot implements Surcharge{
    private static final int firsthour_fee=30;
    private static final int furtherhour_fee=20;
    @Override
    public long fee() {
        return 0;
    }

    @Override
    public long surcharge() {
        return 15;
    }
}
