package kenakata.payment;

public interface PaymentMethod {
    int remainingLimit();

    void authorise(int i);
}
