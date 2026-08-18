public class Bike extends Slot {
    @Override
    public String getKindName() {
        return "BIKE";
    }

    @Override
    public int getFirstHourRate() {
        return 10;
    }

    @Override
    public int getFurtherHourRate() {
        return 5;
    }

    @Override
    public int getSurcharge() {
        return 0;
    }





}
