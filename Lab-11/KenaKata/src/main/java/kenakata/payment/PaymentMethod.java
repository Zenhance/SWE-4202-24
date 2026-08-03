package kenakata.payment;
import kenakata.exceptions.PaymentDeclinedException;


public interface PaymentMethod  {
    void authorise(long amount) throws PaymentDeclinedException;
}
//Explicitly notifies callers that calling this method can fail,
// requiring the caller to catch and handle payment failures gracefully.
