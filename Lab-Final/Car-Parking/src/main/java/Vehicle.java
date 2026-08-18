import exceptions.NoPlateException;

import javax.swing.*;

public abstract class Vehicle {
    private final String plate;
    private Slot slotType;
    private int timeStayed;
    private static int maxTimeStay;
    private boolean isParked;
    private DiscountScheme discountType;

    public Vehicle(String plate, String discountType) throws NoPlateException {
        if (plate.equals("-"))
            throw new NoPlateException("Plate was left blank");
        this.plate = plate;

        if (discountType.equals("NONE"))
            this.discountType = new NoDiscount();
        if (discountType.equals("STUDENT"))
            this.discountType = new StudentDiscount();
        if (discountType.equals("WEEKEND"))
            this.discountType = new WeekendDiscount();

        this.timeStayed = 0;
        isParked = false;
    }

    public void setSlotType(Slot slotType) {
        if (slotType == null)
            throw new IllegalArgumentException("Preferred slot type cannot be null");
        this.slotType = slotType;
    }

    public int getTimeStayed() {
        return timeStayed;
    }

    public void timePassed(int hours) {
        timeStayed += hours;
    }

    public static void setMaxTimeStay(int maxTimeStay) {
        if (maxTimeStay <= 0)
            throw new IllegalArgumentException("Max time stay cannot be neagtive or zero");
        Vehicle.maxTimeStay = maxTimeStay;
    }

    public int getMaxTimeStay() {
        return maxTimeStay;
    }

    public void park() {
        isParked = true;
    }

    public String getPlate() {
        return plate;
    }
}
