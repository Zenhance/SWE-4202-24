public abstract class Slot {
    private boolean isFree;
    private int firstHourFee;
    private int laterFee;
    private int surcharge;


    public Slot() {
        this.isFree = true;
    }

    public void setFirstHourFee(int firstHourFee) {
        if (firstHourFee <= 0)
            throw new IllegalArgumentException("First hour fee cannot negative or zero");
        this.firstHourFee = firstHourFee;
    }

    public void setLaterFee(int laterFee) {
        if (laterFee <= 0)
            throw new IllegalArgumentException("Later fee cannot be negative or zero");
        this.laterFee = laterFee;
    }

    public void setSurcharge(int surcharge) {
        if (surcharge < 0)
            throw new IllegalArgumentException("Surcharge cannot be negative but can be zero");
        this.surcharge = surcharge;
    }
}
