package kenakata.payment;
import kenakata.exceptions.CodCeilingExceededException;

public final class CashOnDeliveryPayment implements PaymentMethod{
    public static final long CEILING = 15_000;
    @Override
    public void validate(long amount) throws CodCeilingExceededException {
        PaymentMethod.requireNonNegative(amount);
        if(amount>CEILING){
            throw new CodCeilingExceededException("Cash on delivery ceiling is Tk "+CEILING);
        }
    }
    @Override
    public void authorise(long amount)throws CodCeilingExceededException {
        validate(amount);
    }
}
