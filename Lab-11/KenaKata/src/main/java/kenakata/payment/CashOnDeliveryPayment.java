
package kenakata.payment;

import kenakata.exceptions.*;

public class CashOnDeliveryPayment implements PaymentMethod {
    private static final long CEILING = 15000;

    @Override
    public void authorise(long amount) throws CheckoutException{
        if (amount > CEILING) throw new CodCeilingExceededException("COD ceiling exceeded");
    }
}
