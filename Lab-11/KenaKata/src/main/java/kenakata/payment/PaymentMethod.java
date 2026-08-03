package kenakata.payment;

public interface PaymentMethod {
    void authorise(int amount);
}
