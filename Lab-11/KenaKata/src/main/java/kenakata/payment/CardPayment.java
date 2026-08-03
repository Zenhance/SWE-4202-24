package kenakata.payment;

public class CardPayment implements PaymentMethod{
    private double remainingLimit;

    public double remainingLimit() {
        return remainingLimit;
    }
    public void authorise(double amount) {

    }
}
