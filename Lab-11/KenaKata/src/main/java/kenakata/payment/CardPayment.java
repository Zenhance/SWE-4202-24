package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.PaymentDeclinedException;


public class CardPayment implements PaymentMethod {
    private long amount;
    public CardPayment(long n) {
        if (n < 0) {
            throw new IllegalArgumentException();
        }

        this.amount = n;
    }
}
