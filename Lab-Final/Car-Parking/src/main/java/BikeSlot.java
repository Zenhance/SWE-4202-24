public class BikeSlot extends Slot {

    @Override
    public String type() {
        return "BIKE";
    }

    @Override
    protected int firstHourFare() {
        return 10;
    }

    @Override
    protected int furtherHourFare() {
        return 5;
    }

    @Override
    protected int surcharge() {
        return 0;
    }
}
