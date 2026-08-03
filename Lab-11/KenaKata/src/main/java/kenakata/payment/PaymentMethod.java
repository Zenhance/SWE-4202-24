package kenakata.payment;

public interface PaymentMethod {
    void authorise(double amount);
}
