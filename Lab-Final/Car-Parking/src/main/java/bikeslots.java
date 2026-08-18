public class bikeslots extends Slot implements Surcharge{
    @Override
    public long fee() {
        return 0;
    }

    @Override
    public long surcharge() {
        return 0;
    }
}
