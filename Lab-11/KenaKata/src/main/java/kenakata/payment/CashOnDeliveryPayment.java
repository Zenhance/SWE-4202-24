package kenakata.payment;
import kenakata.exceptions.CodCeilingExceededException;

public class CashOnDeliveryPayment implements PaymentMethod {

    @Override
    public void authorise(long amount) throws CodCeilingExceededException {
        if (amount > 15000) {
            throw new CodCeilingExceededException("COD ceiling of 15,000 Taka exceeded.");
        }
    }
}