public class RegularSlot extends Slot {

    @Override
    public String type() {
        return "REGULAR";
    }

    @Override
    protected int firstHourFare() {
        return 30;
    }

    @Override
    protected int furtherHourFare() {
        return 20;
    }

    @Override
    protected int surcharge() {
        return 15;
    }
}
