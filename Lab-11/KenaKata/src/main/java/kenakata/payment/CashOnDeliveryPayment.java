package kenakata.payment;

public class CashOnDeliveryPayment implements PaymentMethod{
    @Override
    public long remainingLimit() {
        return 0;
    }
    @Override
    public void authorise(long amount) {

    }
}
