package main.java;

public class StudentDis extends Scheme{

    @Override
    public int applyDiscount(int bill) {
        return bill - (20*bill/100);
    }
}
