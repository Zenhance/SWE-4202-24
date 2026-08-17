package kenakata.payment;

import kenakata.exceptions.CardLimitExceededException;
import kenakata.exceptions.CodCeilingExceededException;
import kenakata.exceptions.EmptyWalletException;

public abstract class PaymentMethod {
    Wallet wallet;
    int amount;
    public abstract void authorise(int amount) throws EmptyWalletException, CodCeilingExceededException, CardLimitExceededException;
}
