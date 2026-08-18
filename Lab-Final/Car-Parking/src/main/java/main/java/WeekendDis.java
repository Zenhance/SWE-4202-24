package main.java;

public class WeekendDis extends Scheme{
    @Override
    public int applyDiscount(int bill) {
        return Math.max(0, bill - 10);
    }
}
