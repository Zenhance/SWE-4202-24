public class LargeSlot extends Slot{
    static int count = 0;
    private final int first_hour = 50;
    private final int further_hour = 40;
    private final int surcharge = 25;
    int hour;

    public int fee() {
        return first_hour + (hour - 1) * further_hour;
    }

    // surcharge when other slot come
}
