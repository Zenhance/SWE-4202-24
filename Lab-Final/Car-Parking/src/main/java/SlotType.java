public enum SlotType {
    BIKE(10,5,0),
    CAR(30,20,15),
    TRUCK(50,40,25);
    private int firstHour;
    private int furtherHour;
    private int surcharge;
    SlotType(int firstHour,int furtherHour,int surcharge){
        this.firstHour=firstHour;
        this.furtherHour=furtherHour;
        this.surcharge=surcharge;
    }

    public int getFirstHour() {
        return firstHour;
    }

    public int getFurtherHour() {
        return furtherHour;
    }

    public int getSurcharge() {
        return surcharge;
    }
}
