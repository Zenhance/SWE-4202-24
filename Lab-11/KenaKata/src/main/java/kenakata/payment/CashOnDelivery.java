package kenakata.payment;

import kenakata.exception.CodLimitExceededException;
import kenakata.util.Validate;

public class CashOnDelivery implements PaymentMethod {

    public static final long DEFAULT_COD_CEILING = 15_000;

    private final long ceiling;

    public CashOnDelivery() {
        this(DEFAULT_COD_CEILING);
    }

    public CashOnDelivery(long ceiling) {
        this.ceiling = Validate.nonNegative(ceiling,
                "COD ceiling"
        );
    }

    public long getCeiling() {
        return ceiling;
    }

    public long getCodCeiling() {
        return ceiling;
    }


    @Override
    public void authorize(long amount) throws CodLimitExceededException {

        Validate.nonNegative(
                amount,
                "Payment amount"
        );

        if (amount > ceiling) {
            throw new CodLimitExceededException("Cash-on-delivery ceiling exceeded. " + "Order total: " + amount + " Taka, COD ceiling: " + ceiling + " Taka."
            );
        }
    }

    @Override
    public String toString() {
        return "CashOnDelivery{ceiling=" + ceiling + "}";
    }
}