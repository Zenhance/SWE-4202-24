package kenakata.payment;
import kenakata.exceptions.CodCeilingExceededException;

public final class CashOnDeliveryPayment implements PaymentMethod{
    public static final long CEILING = 15_000;

}
