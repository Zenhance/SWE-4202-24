package kenakata.payment;

public abstract class PaymentMethod {
    public abstract void authorise(int amount);
}
