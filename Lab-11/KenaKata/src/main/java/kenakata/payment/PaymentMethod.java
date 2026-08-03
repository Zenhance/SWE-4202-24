package kenakata.payment;
import kenakata.exceptions.PaymentDeclinedException;

public interface PaymentMethod {
    default void validate(long amount)throws PaymentDeclinedException{
        requireNonNegative(amount);
    }
    static void requireNonNegative(long amount){
        if(amount<0){
            throw new IllegalArgumentException("Payment amount cannot be negative");
        }
    }
    void authorise(long amount)throws PaymentDeclinedException;
}
