public class BikeSlot extends Slot {
    static int count = 0;
    private final int first_hour = 10;
    private final int further_hour = 5;
    private final int surcharge = 0;
    int hour;

    public int fee() {
        return first_hour + (hour - 1) * further_hour;
    }

    // surcharge when other slot come
}