public class Eviction implements Departure {

    @Override
    public int hoursBilled(int hoursStood, int maxStay) {
        return maxStay + removalHours(maxStay);
    }

    private int removalHours(int maxStay) {
        return (maxStay * 10 + 99) / 100;
    }
}
