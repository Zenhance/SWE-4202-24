package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.CheckoutException;

public class CardPayment implements PaymentMethod {
        private long limit;
        public CardPayment(long limit){
            if(limit<0){
                throw new IllegalArgumentException("Card limit cannot be negative.");
            }
            this.limit= limit;
        }
        public long remainingLimit(){
            return limit;
        }
        @Override
        public void validate(long amount) throws CheckoutException {
            PaymentMethod.requireNonNegative(amount);
            if(amount>limit){
                throw new CardLimitExceededException("Card limit exceeded");
            }
        }
        @Override
        public void authorise(long amount) throws CheckoutException {
            validate(amount);
            limit-=amount;
        }
}

