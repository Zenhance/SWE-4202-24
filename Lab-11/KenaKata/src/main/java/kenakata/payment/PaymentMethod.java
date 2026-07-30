package kenakata.payment;
import kenakata.exceptions.CheckoutException;

public interface PaymentMethod {
    void authorise(int amount) throws CheckoutException;
}
