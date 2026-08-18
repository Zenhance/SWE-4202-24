public enum SlotKind {
    BIKE(10, 5, 0),
    REGULAR(30, 20, 15),
    LARGE(50, 40, 25);

    private final int firstHour;
    private final int furtherHour;
    private final int surcharge;

    SlotKind(int firstHour,int furtherHour,int surcharge) {
        this.firstHour = firstHour;
        this.furtherHour = furtherHour;
        this.surcharge = surcharge;
    }

    public int price(int hours, SlotKind vehicleKind) {
        int amount = firstHour+(hours-1)*furtherHour;

        if (this != vehicleKind) {
            amount += surcharge;
        }

        return amount;
    }
}