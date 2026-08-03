package kenakata.payment;
import kenakata.exceptions.CodCeilingExceededException;
public final class CashOnDeliveryPayment
        implements PaymentMethod {

    public static final long CEILING = 15_000;

    @Override
    public void authorise(long amount)
            throws CodCeilingExceededException {

        if (amount < 0) {
            throw new IllegalArgumentException(
                    "Payment amount cannot be negative"
            );
        }

        if (amount > CEILING) {
            throw new CodCeilingExceededException(
                    "Cash on delivery is limited to Tk "
                            + CEILING
            );
        }

    }
}