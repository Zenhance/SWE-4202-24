package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.PaymentDeclinedException;

public abstract class   PaymentMethod {
     public void authorise(long value) throws PaymentDeclinedException {

    }
}
