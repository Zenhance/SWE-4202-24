package kenakata.payment;

import kenakata.exceptions.CheckoutException;

public interface PaymentMethod {
        public void authorise(long amount) throws CheckoutException;
        public void validate(long amount) throws CheckoutException;
        
        static void requireNonNegative(long amount) {
            if(amount<0){
                throw new IllegalArgumentException("Amount must be positive");
            }
        }
}
