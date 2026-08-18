package main.java;

public class NoDis extends Scheme{
    @Override
    public int applyDiscount(int bill) {
        return bill;
    }
}
