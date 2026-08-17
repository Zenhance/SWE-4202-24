package main.java;

public class LargeSlot extends Slot{
    public LargeSlot(int firstHourRate, int furtherHourRate, int surchargeRate) {
        super(50, 40, 25);
    }

    @Override
    public String getSlot() {
        return "Large";
    }
}
