package kenakata.payment;

import kenakata.exceptions.CodCeilingExceededException;
import kenakata.exceptions.PaymentDeclinedException;

public class CashOnDeliveryPayment implements PaymentMethod {
    public void authorise(int i) throws CodCeilingExceededException {
    }

    @Override
    public void authorise(long amount) throws PaymentDeclinedException {

    }
}
