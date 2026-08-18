package main.java;

public class LargeSlot extends Slot{
    public LargeSlot() {
        super(50, 40, 25);
    }

    @Override
    public String getSlot() {
        return "Large";
    }
}
