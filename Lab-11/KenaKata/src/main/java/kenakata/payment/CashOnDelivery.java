package kenakata.payment;
import kenakata.exceptions.CodCeilingExceededException;

public final class CashOnDelivery implements PaymentMethod {

    private static final long COD_CEILING = 15_000;

    @Override
    public void authorise(long amount) throws CodCeilingExceededException {
        if (amount > COD_CEILING) {
            throw new CodCeilingExceededException(
                    "amount " + amount + " exceeds COD ceiling " + COD_CEILING);
        }
    }
}