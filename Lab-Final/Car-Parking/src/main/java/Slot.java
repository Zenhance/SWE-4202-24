public abstract  class Slot {
    private final int  hour;
    private final int furtherHour;
    private final int subCharge;
    Slot(int hour,int furtherHour,int subCharge){
        this.hour=hour;
        this.furtherHour=furtherHour;
        this.subCharge=subCharge;
    }

}
