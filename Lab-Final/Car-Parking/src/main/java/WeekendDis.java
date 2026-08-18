package main.java;

public class WeekendDis extends Scheme{
    @Override
    public int applyDiscount(int bill) {
        return bill - 10;
    }
}
