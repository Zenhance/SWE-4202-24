package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment extends PaymentMethod {
    public void authorise(int amount) throws CodCeilingExceededException {
        if(amount >15000) throw new CodCeilingExceededException();
    }
}
