package kenakata.payment;
import kenakata.exceptions.PaymentDeclinedException;
public class PaymentMethod {
    void authorise(long amount) throws PaymentDeclinedException;
}
