package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.CodCeilingExceededException;

public abstract class PaymentMethod {
    public void authorise(int amount) {

    }
}
