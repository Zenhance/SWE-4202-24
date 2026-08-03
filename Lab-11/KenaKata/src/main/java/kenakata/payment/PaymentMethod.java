package kenakata.payment;

public interface PaymentMethod {
    long remainingLimit();

    void authorise(long amount);
}
