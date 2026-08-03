package kenakata.payment;

import kenakata.exceptions.CheckoutException;
import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment implements PaymentMethod{
    
    @Override
    public void validate(long amount) throws CheckoutException {
        PaymentMethod.requireNonNegative(amount);
        if(amount>15000){
            throw new CodCeilingExceededException("Amount too large");
        }
    }
    @Override
    public void authorise(long amount)throws CheckoutException {
        validate(amount);
    }
}
