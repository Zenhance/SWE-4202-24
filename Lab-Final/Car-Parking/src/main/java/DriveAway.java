public class DriveAway implements Departure {

    @Override
    public int hoursBilled(int hoursStood, int maxStay) {
        return Math.max(hoursStood, 1);
    }
}
