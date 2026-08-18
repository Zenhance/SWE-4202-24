public class regularslots extends Slot implements Surcharge{

    @Override
    public long fee() {
        return 0;
    }

    @Override
    public long surcharge() {
        return 15;
    }
}
