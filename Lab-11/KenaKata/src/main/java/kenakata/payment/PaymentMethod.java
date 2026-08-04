package kenakata.payment;

import kenakata.exceptions.*;

public interface PaymentMethod {
    void authorise(long amount) throws CheckoutException, CardLimitExceededException,  EmptyWalletException;
}

