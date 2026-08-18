public class Regular extends Slot {
    @Override
    public String getKindName() {
        return "REGULAR";
    }

    @Override
    public int getFirstHourRate() {
        return 30;
    }

    @Override
    public int getFurtherHourRate() {
        return 20;
    }

    @Override
    public int getSurcharge() {
        return 15;
    }



}
