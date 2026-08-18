public abstract  class Slot {
    private final int firstHour;
    private final int furtherHour;
    private final int subCharge;
    Slot(int firstHour,int furtherHour,int subCharge){
        this.firstHour =firstHour;
        this.furtherHour=furtherHour;
        this.subCharge=subCharge;
    }

    public int getFirstHour() {
        return firstHour;
    }

    public int getFurtherHour() {
        return furtherHour;
    }

    public int getSubCharge() {
        return subCharge;
    }
}
