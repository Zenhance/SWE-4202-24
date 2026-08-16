package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.CodCeilingExceededException;

public abstract class PaymentMethod {
    Wallet wallet;
    int amount;
    public abstract void authorise(int amount);
}
