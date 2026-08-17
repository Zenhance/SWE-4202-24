package main.java;

public class RegularSlot extends Slot{

    public RegularSlot(int firstHourRate, int furtherHourRate, int surchargeRate) {
        super(30, 20, 15);
    }

    @Override
    public String getSlot() {
        return "Regular";
    }
}
