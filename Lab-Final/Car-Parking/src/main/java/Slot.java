public enum Slot{
    BIKE(10, 5, 0),
    CAR(30, 20, 15),
    TRUCK(40, 40, 25);

    private int first_hour;
    private int further_hour;
    private int surcharge;

    Slot(int first_hour, int further_hour, int surcharge) {
        this.first_hour = first_hour;
        this.further_hour = further_hour;
        this.surcharge = surcharge;
    }

    public int getFirst_hour() {
        return first_hour;
    }

    public int getFurther_hour() {
        return further_hour;
    }

    public int getSurcharge() {
        return surcharge;
    }
}


