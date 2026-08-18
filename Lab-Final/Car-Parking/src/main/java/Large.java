public class Large extends Slot {

    @Override
    public String getKindName() {
        return "LARGE";
    }

    @Override
    public int getFirstHourRate() {
        return 50;
    }

    @Override
    public int getFurtherHourRate() {
        return 40;
    }

    @Override
    public int getSurcharge() {
        return 25;
    }

}
