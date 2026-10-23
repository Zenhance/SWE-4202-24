public class LargeSlot extends Slot {

    @Override
    public String type() {
        return "LARGE";
    }

    @Override
    protected int firstHourFare() {
        return 50;
    }

    @Override
    protected int furtherHourFare() {
        return 40;
    }

    @Override
    protected int surcharge() {
        return 25;
    }
}
