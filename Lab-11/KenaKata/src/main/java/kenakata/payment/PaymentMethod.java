package kenakata.payment;

public interface PaymentMethod {
    public void authorise(long amount);
}
