public class RegularSlot extends Slot {
    static int count = 0;
    private final int first_hour = 30;
    private final int further_hour = 20;
    private final int surcharge = 15;
    int hour;

    public int fee() {
        return first_hour + (hour - 1) * further_hour;
    }

// surcharge when other slot come
}